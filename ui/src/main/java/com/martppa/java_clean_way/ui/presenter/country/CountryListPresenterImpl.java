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
package com.martppa.java_clean_way.ui.presenter.country;

import com.martppa.java_clean_way.core.interactors.country.GetCountries;
import com.martppa.java_clean_way.core.models.Country;
import com.martppa.java_clean_way.ui.models.mappers.CountryModelMapper;
import com.martppa.java_clean_way.ui.view.CountryListView;

import java.util.Collection;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class CountryListPresenterImpl implements CountryListPresenter {
    private CountryListView view;
    private GetCountries getCountries;
    private CountryModelMapper countryModelMapper;

    @Inject
    public CountryListPresenterImpl(GetCountries getCountries, CountryModelMapper countryModelMapper) {
        this.getCountries = getCountries;
        this.countryModelMapper = countryModelMapper;
    }

    @Override
    public void setView(CountryListView view) {
        this.view = view;
    }

    @Override
    public void requestCountries() {
        getCountries.execute(new GetCountriesObserver(), null);
    }

    @Override
    public void init() {
        // Unused
    }

    @Override
    public void pause() {
        // Unused
    }

    @Override
    public void resume() {
        // Unused
    }

    @Override
    public void finish() {
        getCountries.dispose();
    }

    private class GetCountriesObserver extends DisposableObserver<Collection<Country>> {
        @Override
        public void onNext(Collection<Country> countries) {
            view.renderCountries(countryModelMapper.transform(countries));
        }

        @Override
        public void onError(Throwable e) {
            view.showErrorMessage(e.getMessage());
        }

        @Override
        public void onComplete() {
            // Unused
        }
    }
}
