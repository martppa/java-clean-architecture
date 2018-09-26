package com.martppa.java_clean_way.android.threading;

import com.martppa.java_clean_way.core.threading.ObserverThreadExecutor;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainExecutionThread implements ObserverThreadExecutor {

    @Inject
    public MainExecutionThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
