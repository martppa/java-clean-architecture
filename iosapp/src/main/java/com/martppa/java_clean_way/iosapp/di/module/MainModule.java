package com.martppa.java_clean_way.iosapp.di.module;

import com.martppa.iosapp_data.RetrofitRestFramework;
import com.martppa.java_clean_way.core.repository.CountryRepository;
import com.martppa.java_clean_way.core.threading.ObserverThreadExecutor;
import com.martppa.java_clean_way.core.threading.SubscribedThreadExecutor;
import com.martppa.java_clean_way.data.repository.CountryRepositoryImpl;
import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;
import com.martppa.java_clean_way.data.repository.datasource.network.CountryNetworkDataSource;
import com.martppa.java_clean_way.data.repository.datasource.provider.CountryProvider;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestApi;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestProvider;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.GroupKt.GroupKtCountryRestApi;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.RestCountries.RestCountriesCountryRestApi;
import com.martppa.java_clean_way.data.threading.JobExecutor;
import com.martppa.java_clean_way.data.threading.WorkerExecutionThread;
import com.martppa.java_clean_way.iosapp.threading.MainExecutionThread;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenter;
import com.martppa.java_clean_way.ui.presenter.country.CountryListPresenterImpl;

import java.util.concurrent.Executor;

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
    CountryRestApi provideCountryRestApi(GroupKtCountryRestApi countryRestApi) {
        return countryRestApi;
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
    RestFramework provideRestFramework(RetrofitRestFramework retrofitRestFramework) {
        return retrofitRestFramework;
    }

    @Provides
    Executor provideExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }
}
