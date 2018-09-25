package com.martppa.core.interactors.country;

import com.martppa.core.interactors.ObservableUseCase;
import com.martppa.core.models.Country;
import com.martppa.core.repository.CountryRepository;
import com.martppa.core.threading.ObserverThreadExecutor;
import com.martppa.core.threading.SubscribedThreadExecutor;

import java.util.Collection;

import javax.inject.Inject;

import io.reactivex.Observable;

public class GetCountries extends ObservableUseCase<Collection<Country>, Void> {

    private CountryRepository countryRepository;

    @Inject
    public GetCountries(SubscribedThreadExecutor executionThread,
                        ObserverThreadExecutor uiExecutionThread,
                        CountryRepository countryRepository) {
        super(executionThread, uiExecutionThread);
        this.countryRepository = countryRepository;
    }

    @Override
    protected Observable buildUseCaseObservable(Void aVoid) {
        return countryRepository.getCountries();
    }
}
