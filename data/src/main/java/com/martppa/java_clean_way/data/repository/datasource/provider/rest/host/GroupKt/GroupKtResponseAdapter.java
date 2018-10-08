package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.GroupKt;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.datasource.provider.rest.response.ResponseAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

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
