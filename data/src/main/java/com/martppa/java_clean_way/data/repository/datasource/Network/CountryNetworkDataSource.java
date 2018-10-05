package com.martppa.java_clean_way.data.repository.datasource.Network;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;
import com.martppa.java_clean_way.data.repository.datasource.provider.CountryProvider;

import java.util.Collection;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CountryNetworkDataSource implements CountryDataSource {
    private CountryProvider countryProvider;

    @Inject
    public CountryNetworkDataSource(CountryProvider countryProvider) {
        this.countryProvider = countryProvider;
    }

    @Override
    public Observable<Collection<CountryEntity>> getCountries() {
        return countryProvider.getCountries();
    }
}
