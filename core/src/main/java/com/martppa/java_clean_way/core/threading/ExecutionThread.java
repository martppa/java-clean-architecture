package com.martppa.java_clean_way.core.threading;

import io.reactivex.Scheduler;

public interface ExecutionThread {
    Scheduler getScheduler();
}

