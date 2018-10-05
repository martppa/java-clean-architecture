package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.RestCountries;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.RestResponseAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RestCountriesResponseAdapter extends RestResponseAdapter<Collection<CountryEntity>, List<RestCountriesCountryModel>> {

    private ResponseAdapter.ResponseStatus responseStatus;
    private String errorMessage;

    public RestCountriesResponseAdapter(List<RestCountriesCountryModel> response) {
        super(response);
        this.responseStatus = ResponseStatus.OK;
    }

    public RestCountriesResponseAdapter(ResponseStatus responseStatus, String errorMessage) {
        super(null);
        this.responseStatus = responseStatus;
        this.errorMessage = errorMessage;
    }

    public ResponseAdapter.ResponseStatus getStatus() {
        return responseStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public Collection<CountryEntity> getContent() {
        return new ArrayList<>(response);
    }
}
