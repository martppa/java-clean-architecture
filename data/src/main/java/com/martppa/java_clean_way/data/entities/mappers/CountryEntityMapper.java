package com.martppa.java_clean_way.data.entities.mappers;

import com.martppa.java_clean_way.core.models.Country;
import com.martppa.java_clean_way.data.entities.CountryEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

public class CountryEntityMapper {

    @Inject
    public CountryEntityMapper() {}

    public Country transform(CountryEntity countryEntity) {
        return new Country(countryEntity.getName(), countryEntity.getIsoCode(), countryEntity.getFlagImageUrl());
    }

    public List<Country> transform(Collection<CountryEntity> countryEntities) {
        List<Country> countries = new ArrayList<>();
        for (CountryEntity countryEntity : countryEntities) {
            countries.add(transform(countryEntity));
        }
        return countries;
    }
}
