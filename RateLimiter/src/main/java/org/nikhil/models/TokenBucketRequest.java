package org.nikhil.models;

public class TokenBucketRequest {
    private int bucket;
    private long lastRefillMilliSecond;

    public TokenBucketRequest(int bucket, long lastRefillMilliSecond) {
        this.bucket = bucket;
        this.lastRefillMilliSecond = lastRefillMilliSecond;
    }

    public int getBucket() {
        return bucket;
    }

    public long getLastRefillMilliSecond() {
        return lastRefillMilliSecond;
    }

    public void setBucket(int bucket) {
        this.bucket = bucket;
    }

    public void setLastRefillMilliSecond(long lastRefillMilliSecond) {
        this.lastRefillMilliSecond = lastRefillMilliSecond;
    }
}
