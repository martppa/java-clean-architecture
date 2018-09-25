package com.martppa.javacleanway.ios.threading;

import com.martppa.ui.threading.UiExecutionThread;

public class MainExecutionThread implements UiExecutionThread {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.single();
    }
}
