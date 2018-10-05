package com.martppa.java_clean_way.data.threading;

import com.martppa.java_clean_way.core.threading.SubscribedThreadExecutor;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class WorkerExecutionThread implements SubscribedThreadExecutor {

    private Executor executor;

    @Inject
    public WorkerExecutionThread(Executor executor) {
        this.executor = executor;
    }

    @Override
    public Scheduler getScheduler() {
        return Schedulers.from(executor);
    }
}
