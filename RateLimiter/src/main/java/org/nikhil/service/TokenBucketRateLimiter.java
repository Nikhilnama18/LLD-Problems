package org.nikhil.service;

import org.nikhil.enums.RateLimitStatus;
import org.nikhil.models.TokenBucketRequest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements IRateLimiter {
    private final int bucketSize;
    private final long refillTimeMS;
    private final int refillSize;
    private final Map<String, TokenBucketRequest>requests;

    public TokenBucketRateLimiter(int bucketSize, int refillTimeMS, int refillSize) {
        this.bucketSize = bucketSize;
        this.refillTimeMS = refillTimeMS;
        this.refillSize = refillSize;
        this.requests = new ConcurrentHashMap<>();
    }

    @Override
    public RateLimitStatus allowRequest(String ip) {
        long curTime = System.currentTimeMillis();

        TokenBucketRequest request = requests.computeIfAbsent(
                ip,
                key-> new TokenBucketRequest(bucketSize, curTime)
        );

        synchronized (request){
            long timeDiff = curTime - request.getLastRefillMilliSecond();
            long intervalsPassed = timeDiff / refillTimeMS;

            if (intervalsPassed > 0) {
                int refillAmount = Math.toIntExact(intervalsPassed * refillSize);

                request.setBucket(
                        Math.min(bucketSize, request.getBucket() + refillAmount)
                );

                request.setLastRefillMilliSecond(
                        request.getLastRefillMilliSecond() + intervalsPassed * refillTimeMS
                );
            }

            if (request.getBucket() > 0) {
                request.setBucket(request.getBucket() - 1);
                return RateLimitStatus.ACCEPTED;
            }

            return RateLimitStatus.BLOCKED;
        }
    }
}
