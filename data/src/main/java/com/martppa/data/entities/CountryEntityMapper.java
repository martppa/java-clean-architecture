package com.martppa.data.entities;

import com.martppa.core.models.Country;

import java.util.ArrayList;
import java.util.Collection;

public class CountryEntityMapper {

    public Country transform(CountryEntity countryEntity) {
        return new Country(countryEntity.getName(), countryEntity.getIsoCode(), countryEntity.getFlagImageUrl());
    }

    public Collection<Country> transform(Collection<CountryEntity> countryEntities) {
        Collection<Country> countries = new ArrayList<>();
        for (CountryEntity countryEntity : countryEntities) {
            countries.add(transform(countryEntity));
        }
        return countries;
    }
}
