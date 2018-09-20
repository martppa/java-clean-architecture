package com.martppa.data.repository.datasource;

import com.martppa.data.entities.CountryEntity;

import java.util.Collection;

import io.reactivex.Observable;

public interface CountryDataSource {
    Observable<Collection<CountryEntity>> getCountries();
}
