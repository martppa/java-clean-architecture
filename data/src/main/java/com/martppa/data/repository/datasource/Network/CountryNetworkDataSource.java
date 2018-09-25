package com.martppa.data.repository.datasource.Network;

import com.martppa.data.entities.CountryEntity;
import com.martppa.data.repository.datasource.CountryDataSource;
import com.martppa.data.repository.datasource.provider.CountryProvider;

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
