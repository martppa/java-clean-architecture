package com.martppa.java_clean_way.data.entities;

public class TestCountryEntity implements CountryEntity {
    private String name;
    private String isoCode;
    private String flag;

    public TestCountryEntity(String name, String isoCode, String flag) {
        this.name = name;
        this.isoCode = isoCode;
        this.flag = flag;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIsoCode() {
        return isoCode;
    }

    @Override
    public String getFlagImageUrl() {
        return flag;
    }
}
