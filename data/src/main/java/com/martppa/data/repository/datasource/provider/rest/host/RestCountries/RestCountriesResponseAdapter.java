package com.martppa.data.repository.datasource.provider.rest.host.RestCountries;

import com.martppa.data.entities.CountryEntity;
import com.martppa.data.repository.datasource.provider.rest.response.ResponseAdapter;
import com.martppa.data.repository.datasource.provider.rest.response.RestResponseAdapter;

import java.util.ArrayList;
import java.util.Collection;

public class RestCountriesResponseAdapter extends RestResponseAdapter<Collection<CountryEntity>, RestCountriesResponse> {

    private ResponseAdapter.ResponseStatus responseStatus;
    private String errorMessage;

    public RestCountriesResponseAdapter(RestCountriesResponse response) {
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
