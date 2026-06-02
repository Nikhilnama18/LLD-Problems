package org.nikhil.models;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowRequest {
    private Deque<Long>requestTimeStamps;

    public SlidingWindowRequest() {
        this.requestTimeStamps = new ArrayDeque<>();
    }

    public Deque<Long> getRequestTimeStamps() {
        return requestTimeStamps;
    }
}
