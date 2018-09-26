package com.martppa.java_clean_way.ui.view;

import com.martppa.java_clean_way.ui.models.CountryModel;

import java.util.Collection;

public interface CountryListView extends View{
    void renderCountries(Collection<CountryModel> countries);
}
