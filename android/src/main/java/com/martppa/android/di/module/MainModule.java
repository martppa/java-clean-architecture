package com.martppa.android.di.module;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.martppa.android.di.PerActivity;
import com.martppa.android.threading.MainExecutionThread;
import com.martppa.core.repository.CountryRepository;
import com.martppa.core.threading.ObserverThreadExecutor;
import com.martppa.core.threading.SubscribedThreadExecutor;
import com.martppa.data.repository.CountryRepositoryImpl;
import com.martppa.data.repository.datasource.CountryDataSource;
import com.martppa.data.repository.datasource.Network.CountryNetworkDataSource;
import com.martppa.data.repository.datasource.provider.CountryProvider;
import com.martppa.data.repository.datasource.provider.rest.country.CountryRestApi;
import com.martppa.data.repository.datasource.provider.rest.country.CountryRestProvider;
import com.martppa.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.data.repository.datasource.provider.rest.host.RestCountries.RestCountriesCountryRestApi;
import com.martppa.data.threading.JobExecutor;
import com.martppa.data.threading.WorkerExecutionThread;
import com.martppa.remote.resttemplate.RestTemplateFrameworkImpl;
import com.martppa.ui.presenter.country.CountryListPresenter;
import com.martppa.ui.presenter.country.CountryListPresenterImpl;

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
    RestFramework provideRestFramework(RestTemplateFrameworkImpl restTemplateFramework) {
        return restTemplateFramework;
    }

    @Provides
    Executor provideExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }
}
