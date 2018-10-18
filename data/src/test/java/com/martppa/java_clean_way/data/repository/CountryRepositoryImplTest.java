package com.martppa.java_clean_way.data.repository;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.entities.mappers.CountryEntityMapper;
import com.martppa.java_clean_way.data.repository.datasource.CountryDataSource;
import com.martppa.java_clean_way.data.repository.datasource.factory.CountryDataSourceSimpleFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CountryRepositoryImplTest {
    private CountryRepositoryImpl countryRepository;

    @Mock private CountryEntityMapper mockCountryEntityMapper;
    @Mock private CountryDataSourceSimpleFactory mockCountryDataSourceSimpleFactory;
    @Mock private CountryDataSource mockCountryDataSource;

    @Before
    public void setUp() {
        countryRepository = new CountryRepositoryImpl(mockCountryEntityMapper,
                mockCountryDataSourceSimpleFactory);
        given(mockCountryDataSourceSimpleFactory.build()).willReturn(mockCountryDataSource);
    }

    @Test
    public void testGetCountries() {
        List<CountryEntity> fakeCountryEntities = new ArrayList<>();
        given(mockCountryDataSource.getCountries()).willReturn(Observable.just(fakeCountryEntities));
        countryRepository.getCountries();

        verify(mockCountryDataSourceSimpleFactory).build();
        verify(mockCountryDataSource).getCountries();
    }
}