package org.nikhil.service;

import org.nikhil.enums.RateLimitStatus;
import org.nikhil.models.RateLimitRequest;

import java.util.concurrent.ConcurrentHashMap;

public class FixedWindowRateLimiter implements IRateLimiter {
    private int maxAllowedRequests;
    private long allowedWindowMilliSecond;

    private ConcurrentHashMap<String, RateLimitRequest>requests;

    public FixedWindowRateLimiter(int maxAllowedRequests, long allowedWindowMilliSecond) {
        this.maxAllowedRequests = maxAllowedRequests;
        this.allowedWindowMilliSecond = allowedWindowMilliSecond;

        requests = new ConcurrentHashMap<>();
    }

    public RateLimitStatus allowRequest(String IP){
        long currentWindow = System.currentTimeMillis() / this.allowedWindowMilliSecond;

        RateLimitRequest request = requests.computeIfAbsent
                (IP,
                key-> new RateLimitRequest(currentWindow));

        synchronized (request){
            if(currentWindow!=request.getWindowMilliSecond()){
                request.setWindowMilliSecond(currentWindow);
                request.getRequestCount().set(0);
            }
            int count = request.getRequestCount().incrementAndGet();

            if(count> maxAllowedRequests){
                return RateLimitStatus.BLOCKED;
            }
            return RateLimitStatus.ACCEPTED;
        }
    }
}
