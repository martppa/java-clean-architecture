package com.martppa.java_clean_way.android.di.module;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.martppa.java_clean_way.android.di.PerActivity;
import com.martppa.java_clean_way.android.threading.MainExecutionThread;
import com.martppa.java_clean_way.android_data.RestTemplateFramework;
import com.martppa.java_clean_way.core.repository.CountryRepository;
import com.martppa.java_clean_way.core.threading.ObserverThreadExecutor;
import com.martppa.java_clean_way.core.threading.SubscribedThreadExecutor;
import com.martppa.java_clean_way.data.repository.CountryRepositoryImpl;
import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;
import com.martppa.java_clean_way.data.repository.datasource.Network.CountryNetworkDataSource;
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
    @PerActivity
    Activity activity() {
        return this.appCompatActivity;
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
    RestFramework provideRestFramework(RestTemplateFramework restTemplateFramework) {
        return restTemplateFramework;
    }

    @Provides
    Executor provideExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }
}
