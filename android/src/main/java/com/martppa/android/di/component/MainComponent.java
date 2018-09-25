package com.martppa.android.di.component;

import android.app.Activity;

import com.martppa.android.di.PerActivity;
import com.martppa.android.di.module.ApplicationModule;
import com.martppa.android.di.module.MainModule;
import com.martppa.android.views.MainActivity;

import dagger.Component;

@PerActivity
@Component(modules = {MainModule.class}, dependencies = {ApplicationComponent.class})
public interface MainComponent {
    Activity activity();
    void inject(MainActivity mainActivity);
}
