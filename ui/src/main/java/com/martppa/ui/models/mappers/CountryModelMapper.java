package com.martppa.ui.models.mappers;

import com.martppa.core.models.Country;
import com.martppa.ui.models.CountryModel;

import java.util.ArrayList;
import java.util.Collection;

public class CountryModelMapper {

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
