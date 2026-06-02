package org.nikhil.models;

import java.util.concurrent.atomic.AtomicInteger;

public class RateLimitRequest {
    private volatile Long windowMilliSecond;
    private AtomicInteger requestCount;

    public RateLimitRequest(long windowMilliSecond) {
        this.windowMilliSecond = windowMilliSecond;
        this.requestCount = new AtomicInteger(0);
    }

    public void setWindowMilliSecond(long windowMilliSecond) {
        this.windowMilliSecond = windowMilliSecond;
    }

    public long getWindowMilliSecond() {
        return windowMilliSecond;
    }

    public AtomicInteger getRequestCount() {
        return requestCount;
    }
}
