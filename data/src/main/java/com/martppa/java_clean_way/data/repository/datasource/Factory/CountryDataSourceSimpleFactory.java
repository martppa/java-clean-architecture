package com.martppa.java_clean_way.data.repository.datasource.Factory;

import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;

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
