package com.martppa.data.repository.datasource.provider.rest.host.RestCountries;

import com.martppa.data.entities.CountryEntity;
import com.martppa.data.repository.datasource.provider.rest.country.CountryRestApiImpl;
import com.martppa.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.io.IOException;
import java.util.Collection;

public class RestCountriesCountryRestApi extends CountryRestApiImpl {
    private final String BASE_URL = "https://restcountries.eu/";
    private final String COUNTRY_ROUTE = "rest/v2/all";

    protected RestCountriesCountryRestApi(RestFramework restFramework) {
        super(restFramework);
    }

    @Override
    protected ResponseAdapter<Collection<CountryEntity>> requestCountries() {
        try {
            RestCountriesResponse response = restFramework.executeGet(BASE_URL, COUNTRY_ROUTE, noParameters());
            if (response == null)
                throw new IOException("No data from server");
            return new RestCountriesResponseAdapter(response);
        } catch (IOException ioex) {
            return new RestCountriesResponseAdapter(ResponseAdapter.ResponseStatus.ERROR, ioex.getLocalizedMessage());
        }
    }
}
