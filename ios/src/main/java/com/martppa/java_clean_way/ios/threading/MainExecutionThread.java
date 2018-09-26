package com.martppa.java_clean_way.ios.threading;

import com.martppa.java_clean_way.ui.threading.UiExecutionThread;

public class MainExecutionThread implements UiExecutionThread {
    @Override
    public Scheduler getScheduler() {
        return Schedulers.single();
    }
}
