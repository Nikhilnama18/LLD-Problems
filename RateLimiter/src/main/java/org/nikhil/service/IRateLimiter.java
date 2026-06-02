package org.nikhil.service;

import org.nikhil.enums.RateLimitStatus;

public interface IRateLimiter {
    public RateLimitStatus allowRequest(String ip);
}
