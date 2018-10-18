package com.martppa.java_clean_way.data.repository.datasource.network;

import com.martppa.java_clean_way.data.repository.datasource.provider.CountryProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import io.reactivex.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CountryNetworkDataSourceTest {
    private CountryNetworkDataSource countryNetworkDataSource;

    @Mock private CountryProvider mockCountryProvider;

    @Before
    public void setUp() {
        countryNetworkDataSource = new CountryNetworkDataSource(mockCountryProvider);
    }

    @Test
    public void testGetCountries() {
        given(mockCountryProvider.getCountries()).willReturn(Observable.just(new ArrayList<>()));
        countryNetworkDataSource.getCountries();
        verify(mockCountryProvider).getCountries();
    }
}