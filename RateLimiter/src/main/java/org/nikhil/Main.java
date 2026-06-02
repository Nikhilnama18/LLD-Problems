package org.nikhil;

import org.nikhil.enums.RateLimitStatus;
import org.nikhil.models.RateLimitRequest;
import org.nikhil.service.FixedWindowRateLimiter;
import org.nikhil.service.SlidingWindowRateLimiter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws InterruptedException {
        // Fixed Window
        FixedWindowRateLimiter fixedWindowRateLimiter = new FixedWindowRateLimiter(5, 10000);

        String ip = "127.0.0.1";
        for(int i =0; i<8; i++){
            RateLimitStatus status = fixedWindowRateLimiter.allowRequest(ip);

            System.out.println("Req No:" + i + " Status: " + status);
        }

        Thread.sleep(10000);

        for(int i=0; i<3; i++){
            RateLimitStatus status = fixedWindowRateLimiter.allowRequest(ip);
            System.out.println("Req No:" + i + " Status: " + status);
        }

        // Sliding Window

        System.out.println("******* Sliding window rate limiter *********");

        SlidingWindowRateLimiter slidingWindowRateLimiter = new SlidingWindowRateLimiter(10, 10000);
        int reqCount = 1;

        for(int i=0; i<5; i++){
            RateLimitStatus status = slidingWindowRateLimiter.allowRequest(ip);
            Thread.sleep(1000);
            System.out.println("Req No:" + reqCount++ + " Status: " + status);
        }

        for (int i=0; i<6; i++){
            RateLimitStatus status = slidingWindowRateLimiter.allowRequest(ip);
            System.out.println("Req No:" + reqCount++ + " Status: " + status);
        }

        Thread.sleep(6000);

        for (int i=0; i<2; i++){
            RateLimitStatus status = slidingWindowRateLimiter.allowRequest(ip);
            System.out.println("Req No:" + reqCount++ + " Status: " + status);
        }
    }
}
