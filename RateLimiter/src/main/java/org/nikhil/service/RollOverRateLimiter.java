package org.nikhil.service;

import org.nikhil.enums.RateLimitStatus;
import org.nikhil.models.RateLimitRequest;

import java.util.concurrent.ConcurrentHashMap;

public class RollOverRateLimiter {
    private Integer maxAllowedRequests;
    private Long windowMilliSecond;

    private ConcurrentHashMap<String, RateLimitRequest> requests;

    public RollOverRateLimiter(Integer maxAllowedRequests, Long windowMilliSecond) {
        this.maxAllowedRequests = maxAllowedRequests;
        this.windowMilliSecond = windowMilliSecond;

        requests = new ConcurrentHashMap<>();
    }

    public RateLimitStatus allowRequest(String IP){
        Long currentWindow = System.currentTimeMillis();

        RateLimitRequest request =
                requests.computeIfAbsent(IP, key-> new RateLimitRequest(currentWindow));

        synchronized (request){
            if(currentWindow-request.getWindowMilliSecond() > windowMilliSecond){
                request.setWindowMilliSecond(currentWindow);
                request.getRequestCount().set(0);
            }

            int count = request.getRequestCount().incrementAndGet();

            if(count>maxAllowedRequests){
                return RateLimitStatus.BLOCKED;
            }

            return RateLimitStatus.ACCEPTED;
        }
    }
}
