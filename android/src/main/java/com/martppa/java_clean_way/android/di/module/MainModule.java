/*
 * Copyright 2018 Humberto Martín Dieppa, Open source project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.martppa.java_clean_way.android.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.martppa.java_clean_way.android.threading.MainExecutionThread;
import com.martppa.java_clean_way.android_data.cache.country.CountryStoroCache;
import com.martppa.java_clean_way.android_data.remote.RestTemplateFramework;
import com.martppa.java_clean_way.core.repository.CountryRepository;
import com.martppa.java_clean_way.core.threading.ObserverThreadExecutor;
import com.martppa.java_clean_way.core.threading.SubscribedThreadExecutor;
import com.martppa.java_clean_way.data.repository.CountryRepositoryImpl;
import com.martppa.java_clean_way.data.repository.cache.Country.CountryCache;
import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;
import com.martppa.java_clean_way.data.repository.datasource.network.CountryNetworkDataSource;
import com.martppa.java_clean_way.data.repository.datasource.provider.CountryProvider;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestApi;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestProvider;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.RestCountries.RestCountriesCountryRestApi;
import com.martppa.java_clean_way.data.threading.JobExecutor;
import com.martppa.java_clean_way.data.threading.WorkerExecutionThread;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenter;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenterImpl;

import java.util.concurrent.Executor;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private AppCompatActivity appCompatActivity;

    public MainModule(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
    }

    @Provides
    Activity activity() {
        return this.appCompatActivity;
    }

    @Provides
    Context provideContext(Activity activity) {
        return activity;
    }

    @Provides
    CountryListPresenter provideCountryListPresenter(CountryListPresenterImpl countryListPresenter) {
        return countryListPresenter;
    }

    @Provides
    CountryDataSource provideCountryDataSource(CountryNetworkDataSource countryNetworkDataSource) {
        return countryNetworkDataSource;
    }

    @Provides
    CountryRepository provideCountryRespository(CountryRepositoryImpl countryRepository) {
        return countryRepository;
    }

    @Provides
    CountryProvider provideCountryProvider(CountryRestProvider countryRestProvider) {
        return countryRestProvider;
    }

    @Provides
    CountryRestApi provideCountryRestApi(RestCountriesCountryRestApi restCountriesCountryRestApi) {
        return restCountriesCountryRestApi;
    }

    @Provides
    SubscribedThreadExecutor provideSubscriberThreadExecutor(WorkerExecutionThread workerExecutionThread) {
        return workerExecutionThread;
    }

    @Provides
    ObserverThreadExecutor provideObserverThreadExecutor(MainExecutionThread mainExecutionThread) {
        return mainExecutionThread;
    }

    @Provides
    RestFramework provideRestFramework(RestTemplateFramework restFramework) { // <- Replace RestTemplateFramework with for example RetrofitRestFramework!
        return restFramework;
    }

    @Provides
    Executor provideExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    CountryCache provideCache(CountryStoroCache cache) {
        return cache;
    }
}
