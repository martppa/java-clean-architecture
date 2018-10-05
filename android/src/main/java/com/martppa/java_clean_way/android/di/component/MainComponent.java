package com.martppa.java_clean_way.android.di.component;

import android.app.Activity;

import com.martppa.java_clean_way.android.di.PerActivity;
import com.martppa.java_clean_way.android.di.module.MainModule;
import com.martppa.java_clean_way.android.views.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = {MainModule.class})
public interface MainComponent {
    Activity activity();
    void inject(MainActivity mainActivity);
}
