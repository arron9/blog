package com.yunchen.common.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StopWatch implements AutoCloseable {
    private final String name;
    private final long startTime;

    public StopWatch(String name) {
        this.name = name;
        startTime = System.currentTimeMillis();
    }

    public static StopWatch start(String name) {
        return new StopWatch(name);
    }

    public double stop() {
        double timeElapsed = (System.currentTimeMillis() - startTime) / 1000.0D;

        log.info(String.format("===[ Name: %s, Time elapsed: %fs ]===", name, timeElapsed));

        return timeElapsed;
    }

    @Override
    public void close() {
        stop();
    }
}
