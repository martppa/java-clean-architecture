package com.martppa.data.repository;

import com.martppa.core.repository.CountryRepository;
import com.martppa.data.entities.mappers.CountryEntityMapper;
import com.martppa.data.repository.datasource.CountryDataSource;
import com.martppa.data.repository.datasource.Factory.CountryDataSourceSimpleFactory;

import javax.inject.Inject;

import io.reactivex.Observable;

public class CountryRepositoryImpl implements CountryRepository {
    private CountryEntityMapper countryEntityMapper;
    private CountryDataSourceSimpleFactory countryDataSourceSimpleFactory;

    @Inject
    public CountryRepositoryImpl(CountryEntityMapper countryEntityMapper,
                                 CountryDataSourceSimpleFactory countryDataSourceSimpleFactory) {
        this.countryEntityMapper = countryEntityMapper;
        this.countryDataSourceSimpleFactory = countryDataSourceSimpleFactory;
    }

    @Override
    public Observable getCountries() {
        return countryDataSourceSimpleFactory
                .build().getCountries().map(countryEntityMapper::transform);
    }
}
