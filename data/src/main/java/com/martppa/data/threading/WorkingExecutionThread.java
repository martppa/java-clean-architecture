package com.martppa.data.threading;

import com.martppa.core.threading.ExecutionThread;

import java.util.concurrent.Executor;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class WorkingExecutionThread implements ExecutionThread {

    private Executor executor;

    public WorkingExecutionThread(Executor executor) {
        this.executor = executor;
    }

    @Override
    public Scheduler getScheduler() {
        return Schedulers.from(executor);
    }
}
