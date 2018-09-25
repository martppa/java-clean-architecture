package com.martppa.android.threading;

import com.martppa.core.threading.ObserverThreadExecutor;
import com.martppa.ui.threading.UiExecutionThread;

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
