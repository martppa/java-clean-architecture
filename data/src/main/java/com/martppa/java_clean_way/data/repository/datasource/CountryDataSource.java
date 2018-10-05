package com.martppa.java_clean_way.data.repository.datasource;

import com.martppa.java_clean_way.data.entities.CountryEntity;

import java.util.Collection;

import io.reactivex.Observable;

public interface CountryDataSource {
    Observable<Collection<CountryEntity>> getCountries();
}
