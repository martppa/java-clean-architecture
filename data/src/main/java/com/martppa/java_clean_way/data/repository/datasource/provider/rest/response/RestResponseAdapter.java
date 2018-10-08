package com.martppa.java_clean_way.data.repository.datasource.provider.rest.response;

public abstract class RestResponseAdapter<Content, Response> implements ResponseAdapter<Content> {
    protected Response response;
    public RestResponseAdapter(Response response) {
        this.response = response;
    }
}
