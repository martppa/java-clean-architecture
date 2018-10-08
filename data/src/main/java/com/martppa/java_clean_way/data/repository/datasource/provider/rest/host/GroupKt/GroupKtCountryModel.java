package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.GroupKt;

import com.martppa.java_clean_way.data.entities.CountryEntity;

public class GroupKtCountryModel implements CountryEntity {

    private String name;
    private String alpha2_code;
    private String alpha3_code;

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAlpha2_code ()
    {
        return alpha2_code;
    }

    public void setAlpha2_code (String alpha2_code)
    {
        this.alpha2_code = alpha2_code;
    }

    public String getAlpha3_code ()
    {
        return alpha3_code;
    }

    public void setAlpha3_code (String alpha3_code)
    {
        this.alpha3_code = alpha3_code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIsoCode() {
        return alpha2_code;
    }

    @Override
    public String getFlagUrl() {
        return ""; //There is no flag in this host
    }
}
