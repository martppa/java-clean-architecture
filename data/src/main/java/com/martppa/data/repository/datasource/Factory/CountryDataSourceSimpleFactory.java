package com.martppa.data.repository.datasource.Factory;

import com.martppa.data.repository.datasource.CountryDataSource;

public class CountryDataSourceSimpleFactory {
    private CountryDataSource countryCloudDataSource;

    public CountryDataSourceSimpleFactory(CountryDataSource countryCloudDataSource) {
        this.countryCloudDataSource = countryCloudDataSource;
    }

    public CountryDataSource build() {
        return countryCloudDataSource;
    }
}
