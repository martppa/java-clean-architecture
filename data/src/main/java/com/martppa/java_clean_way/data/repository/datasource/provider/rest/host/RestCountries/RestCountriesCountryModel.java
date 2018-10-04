package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.RestCountries;

import com.google.gson.annotations.SerializedName;
import com.martppa.java_clean_way.data.entities.CountryEntity;

public class RestCountriesCountryModel implements CountryEntity {
    @SerializedName("name")
    private String name;
    @SerializedName("alpha2Code")
    private String alpha2Code;
    @SerializedName("flag")
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

    public String getFlagUrl() {
        return flag;
    }
}
