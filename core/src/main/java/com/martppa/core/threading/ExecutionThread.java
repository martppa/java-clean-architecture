package com.martppa.core.threading;

import io.reactivex.Scheduler;

public interface ExecutionThread {
    Scheduler getScheduler();
}

