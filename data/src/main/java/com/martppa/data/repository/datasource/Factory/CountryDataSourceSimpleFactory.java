package com.martppa.data.repository.datasource.Factory;

import com.martppa.data.repository.datasource.CountryDataSource;

import javax.inject.Inject;

public class CountryDataSourceSimpleFactory {
    private CountryDataSource countryCloudDataSource;

    @Inject
    public CountryDataSourceSimpleFactory(CountryDataSource countryCloudDataSource) {
        this.countryCloudDataSource = countryCloudDataSource;
    }

    public CountryDataSource build() {
        return countryCloudDataSource;
    }
}
