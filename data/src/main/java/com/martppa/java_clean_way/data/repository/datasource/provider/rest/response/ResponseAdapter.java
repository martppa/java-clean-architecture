package com.martppa.java_clean_way.data.repository.datasource.provider.rest.response;

public interface ResponseAdapter<Content> {
    ResponseStatus getStatus();
    String getErrorMessage();
    Content getContent();

    enum ResponseStatus
    {
        OK,
        ERROR
    }
}
