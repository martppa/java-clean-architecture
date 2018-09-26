package com.martppa.java_clean_way.data.repository.datasource.provider;

import com.martppa.java_clean_way.data.entities.CountryEntity;

import java.util.Collection;

import io.reactivex.Observable;

public interface CountryProvider {
    Observable<Collection<CountryEntity>> getCountries();
}
