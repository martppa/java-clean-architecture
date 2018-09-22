package com.martppa.android.di;

import com.martppa.di.Injector;

public class AndroidInjector extends Injector {
    private AndroidInjector() {
        build("AndroidConfiguration.xml");
    }
}
