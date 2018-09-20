package com.martppa.data.repository.datasource.provider;

import com.martppa.data.entities.CountryEntity;

import java.util.Collection;

import io.reactivex.Observable;

public interface CountryProvider {
    Observable<Collection<CountryEntity>> getCountries();
}
