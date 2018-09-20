package com.martppa.core.models;

public class Country {
    private String name;
    private String isoCode;
    private String flagImageUrl;

    public Country(String name, String isoCode, String flagImageUrl) {
        this.name = name;
        this.isoCode = isoCode;
        this.flagImageUrl = flagImageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    public String getFlagImageUrl() {
        return flagImageUrl;
    }

    public void setFlagImageUrl(String flagImageUrl) {
        this.flagImageUrl = flagImageUrl;
    }
}
