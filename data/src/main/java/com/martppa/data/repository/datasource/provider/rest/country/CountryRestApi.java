package com.martppa.data.repository.datasource.provider.rest.country;

import com.martppa.data.entities.CountryEntity;

import java.util.Collection;

import io.reactivex.Observable;

public interface CountryRestApi {
    Observable<Collection<CountryEntity>> getCountries();
}
