package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.RestCountries;

import com.martppa.java_clean_way.data.entities.CountryEntity;

public class RestCountriesCountryModel implements CountryEntity {
    private String name;
    private String alpha2Code;
    private String flag;

    public RestCountriesCountryModel(String name, String alpha2Code, String flagImageUrl) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.flag = flagImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getIsoCode() {
        return alpha2Code;
    }

    public String getFlagImageUrl() {
        return flag;
    }
}
