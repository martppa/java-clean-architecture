package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.GroupKt;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestApiImpl;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;

public class GroupKtCountryRestApi extends CountryRestApiImpl {
    private final String BASE_URL = "http://services.groupkt.com/";
    private final String COUNTRY_ROUTE = "country/get/all";

    @Inject
    public GroupKtCountryRestApi(RestFramework restFramework) {
        super(restFramework);
    }

    @Override
    protected ResponseAdapter<Collection<CountryEntity>> requestCountries() {
        try {
            GroupKtRestResponse response = restFramework
                    .executeGet(GroupKtRestResponse.class, BASE_URL, COUNTRY_ROUTE, noParameters());
            return new GroupKtResponseAdapter(response);
        } catch (IOException e) {
            return new GroupKtResponseAdapter(ResponseAdapter.ResponseStatus.ERROR, e.getMessage());
        }
    }
}
