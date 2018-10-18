package com.martppa.java_clean_way.data.repository.datasource.factory;

import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class CountryDataSourceSimpleFactoryTest {
    private CountryDataSourceSimpleFactory countryDataSourceSimpleFactory;

    @Mock
    private CountryDataSource mockedCountryDataSource;

    @Before
    public void setUp() {
        countryDataSourceSimpleFactory = new CountryDataSourceSimpleFactory(mockedCountryDataSource);
    }

    @Test
    public void testBuild() {
        Assert.assertEquals(countryDataSourceSimpleFactory.build(), mockedCountryDataSource);
    }
}