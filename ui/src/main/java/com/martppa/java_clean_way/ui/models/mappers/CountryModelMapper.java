package com.martppa.java_clean_way.ui.models.mappers;

import com.martppa.java_clean_way.core.models.Country;
import com.martppa.java_clean_way.ui.models.CountryModel;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

public class CountryModelMapper {

    @Inject
    public CountryModelMapper() {}

    public Collection<CountryModel> transform(Collection<Country> countries) {
        Collection<CountryModel> countriesModels = new ArrayList<>();
        for (Country country : countries) {
            countriesModels.add(transform(country));
        }
        return countriesModels;
    }

    public CountryModel transform(Country country) {
        return new CountryModel(country.getName(), country.getIsoCode(), country.getFlagImageUrl());
    }
}
