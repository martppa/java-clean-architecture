/*
 *   Copyright (c) 2018 Humberto Martín Dieppa, Open source project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.martppa.java_clean_way.desktop.di.module;

import com.martppa.java_clean_way.desktop_data.cache.CountryEhCache;
import com.martppa.java_clean_way.desktop_data.remote.RetrofitRestFramework;
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
import com.martppa.java_clean_way.desktop.threading.MainExecutionThread;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenter;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenterImpl;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    public MainModule() {

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
    CountryRestApi provideCountryRestApi(RestCountriesCountryRestApi countryRestApi) { // <- replace the rest Api to swap between hosts
        return countryRestApi;
    }

    @Provides
    SubscribedThreadExecutor provideSubscriberThreadExecutor(WorkerExecutionThread workerExecutionThread) {
        return workerExecutionThread;
    }

    @Singleton
    @Provides
    ObserverThreadExecutor provideObserverThreadExecutor(MainExecutionThread mainExecutionThread) {
        return mainExecutionThread;
    }

    @Provides
    RestFramework provideRestFramework(RetrofitRestFramework restFramework) {
        return restFramework;
    }

    @Provides
    Executor provideExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    CountryCache provideCache(CountryEhCache cache) {
        return cache;
    }
}
