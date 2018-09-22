package com.martppa.ui.presenter.country;

import com.martppa.ui.presenter.Presenter;
import com.martppa.ui.view.CountryListView;

public interface CountryListPresenter extends Presenter {
    void requestCountries();
    void setView(CountryListView countryListView);
}
