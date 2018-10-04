package com.martppa.java_clean_way.iosapp.di.component;

import com.martppa.java_clean_way.iosapp.di.module.MainModule;
import com.martppa.java_clean_way.iosapp.views.CountryListViewController;

import dagger.Component;

@Component(modules = {MainModule.class})
public interface MainComponent {
    void inject(CountryListViewController controller);
}