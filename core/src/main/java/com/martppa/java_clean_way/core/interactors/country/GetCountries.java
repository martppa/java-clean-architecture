/*
 * Copyright 2018 Humberto Martín Dieppa, Open source project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.martppa.java_clean_way.core.interactors.country;

import com.martppa.java_clean_way.core.interactors.ObservableUseCase;
import com.martppa.java_clean_way.core.models.Country;
import com.martppa.java_clean_way.core.repository.CountryRepository;
import com.martppa.java_clean_way.core.threading.ObserverThreadExecutor;
import com.martppa.java_clean_way.core.threading.SubscribedThreadExecutor;

import java.util.Collection;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Retrieves a {@link Observable} which will provide a
 * {@link Collection} of {@link Country}.
 */
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
