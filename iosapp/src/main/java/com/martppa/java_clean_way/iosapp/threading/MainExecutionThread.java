package com.martppa.java_clean_way.iosapp.threading;

import com.martppa.java_clean_way.ui.threading.UiExecutionThread;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.ios.schedulers.IOSSchedulers;

public class MainExecutionThread implements UiExecutionThread {
    @Inject
    public MainExecutionThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return IOSSchedulers.mainThread();
    }
}
