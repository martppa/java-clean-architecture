package com.martppa.data.repository;

import com.martppa.core.repository.CountryRepository;
import com.martppa.data.entities.mappers.CountryEntityMapper;
import com.martppa.data.repository.datasource.CountryDataSource;

import io.reactivex.Observable;

public class CountryRepositoryImpl implements CountryRepository {
    private CountryEntityMapper countryEntityMapper;
    private CountryDataSource countryDataSource;

    public CountryRepositoryImpl(CountryEntityMapper countryEntityMapper, CountryDataSource countryDataSource) {
        this.countryEntityMapper = countryEntityMapper;
        this.countryDataSource = countryDataSource;
    }

    @Override
    public Observable getCountries() {
        return countryDataSource.getCountries().map(countryEntityMapper::transform);
    }
}
