package org.nikhil.service;

import org.nikhil.enums.RateLimitStatus;
import org.nikhil.models.SlidingWindowRequest;

import java.util.Deque;
import java.util.concurrent.ConcurrentHashMap;

public class SlidingWindowRateLimiter {
    private final int allowedRequests;
    private final long windowMilliSeconds;

    private ConcurrentHashMap<String, SlidingWindowRequest> requests;

    public SlidingWindowRateLimiter(int allowedRequests, long windowMilliSeconds) {
        this.allowedRequests = allowedRequests;
        this.windowMilliSeconds = windowMilliSeconds;
        this.requests = new ConcurrentHashMap<>();
    }

    public RateLimitStatus allowRequest(String ip){
        long currentWindow = System.currentTimeMillis();

        SlidingWindowRequest request = requests.computeIfAbsent(
                ip,
                key-> new SlidingWindowRequest()
        );

        synchronized (request){
            Deque<Long> timeStamps = request.getRequestTimeStamps();
            while(!timeStamps.isEmpty() && currentWindow- timeStamps.peek() >= windowMilliSeconds){
                timeStamps.pollFirst();
            }

            if(timeStamps.size() >= allowedRequests){
                return RateLimitStatus.BLOCKED;
            }
            timeStamps.addLast(currentWindow);
            return RateLimitStatus.ACCEPTED;
        }
    }
}
