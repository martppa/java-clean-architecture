package com.martppa.java_clean_way.ui.presenter.country;

import com.martppa.java_clean_way.ui.presenter.Presenter;
import com.martppa.java_clean_way.ui.view.CountryListView;

public interface CountryListPresenter extends Presenter {
    void requestCountries();
    void setView(CountryListView countryListView);
}
