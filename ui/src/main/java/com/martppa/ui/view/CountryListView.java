package com.martppa.ui.view;

import com.martppa.ui.models.CountryModel;

import java.util.Collection;

public interface CountryListView extends View{
    void renderCountries(Collection<CountryModel> countries);
}
