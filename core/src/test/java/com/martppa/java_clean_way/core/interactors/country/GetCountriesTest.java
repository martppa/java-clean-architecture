package com.martppa.java_clean_way.core.interactors.country;

import com.martppa.java_clean_way.core.repository.CountryRepository;
import com.martppa.java_clean_way.core.threading.ObserverThreadExecutor;
import com.martppa.java_clean_way.core.threading.SubscribedThreadExecutor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.class)
public class GetCountriesTest {
    @Mock
    private SubscribedThreadExecutor mockSubscribedThreadExecutor;

    @Mock
    private ObserverThreadExecutor mockObserverThreadExecutor;

    @Mock
    private CountryRepository mockCountryRepository;

    private GetCountries getCountries;

    @Before
    public void setUp() {
        getCountries = new GetCountries(mockSubscribedThreadExecutor,
                mockObserverThreadExecutor,
                mockCountryRepository);
    }

    @Test
    public void testGetCountriesUseCaseObservable() {
        getCountries.buildUseCaseObservable(null);

        verify(mockCountryRepository).getCountries();
        verifyNoMoreInteractions(mockCountryRepository);
        verifyNoMoreInteractions(mockSubscribedThreadExecutor);
        verifyNoMoreInteractions(mockObserverThreadExecutor);
    }
}