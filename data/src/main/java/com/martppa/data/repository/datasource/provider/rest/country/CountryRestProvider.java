package com.martppa.data.repository.datasource.provider.rest.country;

import com.martppa.data.entities.CountryEntity;
import com.martppa.data.repository.datasource.provider.CountryProvider;

import java.util.Collection;

import io.reactivex.Observable;

public class CountryRestProvider implements CountryProvider {
    private CountryRestApi countryRestApi;

    public CountryRestProvider(CountryRestApi countryRestApi) {
        this.countryRestApi = countryRestApi;
    }

    @Override
    public Observable<Collection<CountryEntity>> getCountries() {
        return countryRestApi.getCountries();
    }
}
