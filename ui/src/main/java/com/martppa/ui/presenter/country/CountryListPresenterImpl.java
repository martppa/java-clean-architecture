package com.martppa.ui.presenter.country;

import com.martppa.core.interactors.country.GetCountries;
import com.martppa.core.models.Country;
import com.martppa.ui.models.CountryModel;
import com.martppa.ui.models.mappers.CountryModelMapper;
import com.martppa.ui.view.CountryListView;
import com.martppa.ui.view.View;

import java.util.Collection;

import io.reactivex.observers.DisposableObserver;

public class CountryListPresenterImpl implements CountryListPresenter {
    private CountryListView view;
    private GetCountries getCountries;
    private CountryModelMapper countryModelMapper;

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
