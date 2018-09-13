package com.martppa.javacleanway.ios.threading;

import com.martppa.ui.threading.UiExecutionThread;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class MainExecutionThread implements UiExecutionThread {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.single();
    }
}
