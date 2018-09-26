package com.martppa.java_clean_way.data.repository.datasource.provider.rest.country;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

public abstract class CountryRestApiImpl implements CountryRestApi {
    protected RestFramework restFramework;

    protected CountryRestApiImpl(RestFramework restFramework) {
        this.restFramework = restFramework;
    }

    @Override
    public Observable<Collection<CountryEntity>> getCountries() {
        return Observable.create(emitter -> {
            ResponseAdapter<Collection<CountryEntity>> responseAdapter = requestCountries();
            AssertResquestWasSuccessful(responseAdapter);
            emitter.onNext(responseAdapter.getContent());
        });
    }

    protected abstract ResponseAdapter<Collection<CountryEntity>> requestCountries();

    private void AssertResquestWasSuccessful(ResponseAdapter responseAdapter) throws IOException {
        if (responseAdapter.getStatus() != ResponseAdapter.ResponseStatus.OK)
            throw new IOException("Unable to request: " + responseAdapter.getErrorMessage());
    }

    protected Map<String, String> noParameters() {
        return new HashMap<>();
    }
}
