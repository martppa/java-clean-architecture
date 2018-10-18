/*
 * Copyright 2018 Humberto Martín Dieppa, Open source project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.martppa.java_clean_way.data.repository.datasource.provider.rest.country;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework.RestFramework;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Abstract class for Rest flavours.
 */
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
