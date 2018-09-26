package com.martppa.java_clean_way.data.repository.datasource.provider.rest.country;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.CountryProvider;

import java.util.Collection;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CountryRestProvider implements CountryProvider {
    private CountryRestApi countryRestApi;

    @Inject
    public CountryRestProvider(CountryRestApi countryRestApi) {
        this.countryRestApi = countryRestApi;
    }

    @Override
    public Observable<Collection<CountryEntity>> getCountries() {
        return countryRestApi.getCountries();
    }
}
