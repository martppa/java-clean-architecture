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
package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.GroupKt;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Turns <a href="http://www.groupkt.com">GroupKt</a> responses into a common response type
 * handled by {@link com.martppa.java_clean_way.data.repository.datasource.provider.rest.country.CountryRestApiImpl}
 */
public class GroupKtResponseAdapter implements ResponseAdapter<Collection<CountryEntity>> {

    private ResponseStatus responseStatus;
    private GroupKtRestResponse groupKtRestResponse;

    public GroupKtResponseAdapter(GroupKtRestResponse groupKtRestResponse) {
        this.groupKtRestResponse = groupKtRestResponse;
        responseStatus = ResponseStatus.OK;
    }

    public GroupKtResponseAdapter(ResponseStatus responseStatus, String message) {
        this.groupKtRestResponse = new GroupKtRestResponse(message);
        this.responseStatus = responseStatus;
    }

    @Override
    public ResponseStatus getStatus() {
        return responseStatus;
    }

    @Override
    public String getErrorMessage() {
        return groupKtRestResponse.getMessage();
    }

    @Override
    public Collection<CountryEntity> getContent() {
       return new ArrayList<>(Arrays.asList(groupKtRestResponse.getContent()));
    }
}
