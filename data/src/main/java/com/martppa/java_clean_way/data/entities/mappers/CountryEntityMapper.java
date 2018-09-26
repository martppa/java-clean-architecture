package com.martppa.java_clean_way.data.entities.mappers;

import com.martppa.java_clean_way.core.models.Country;
import com.martppa.java_clean_way.data.entities.CountryEntity;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

public class CountryEntityMapper {

    @Inject
    public CountryEntityMapper() {}

    public Country transform(CountryEntity countryEntity) {
        return new Country(countryEntity.getName(), countryEntity.getIsoCode(), countryEntity.getFlagUrl());
    }

    public Collection<Country> transform(Collection<CountryEntity> countryEntities) {
        Collection<Country> countries = new ArrayList<>();
        for (CountryEntity countryEntity : countryEntities) {
            countries.add(transform(countryEntity));
        }
        return countries;
    }
}
