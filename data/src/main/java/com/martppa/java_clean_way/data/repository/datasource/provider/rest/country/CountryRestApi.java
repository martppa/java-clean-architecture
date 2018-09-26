package com.martppa.java_clean_way.data.repository.datasource.provider.rest.country;

import com.martppa.java_clean_way.data.entities.CountryEntity;

import java.util.Collection;

import io.reactivex.Observable;

public interface CountryRestApi {
    Observable<Collection<CountryEntity>> getCountries();
}
