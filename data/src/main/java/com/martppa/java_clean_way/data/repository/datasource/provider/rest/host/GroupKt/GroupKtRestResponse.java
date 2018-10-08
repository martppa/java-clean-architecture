package com.martppa.java_clean_way.data.repository.datasource.provider.rest.host.GroupKt;

public class GroupKtRestResponse
{
    private RestResponse RestResponse;

    public GroupKtRestResponse(String message) {
        RestResponse = new RestResponse(new String[] { message });
    }

    public RestResponse getRestResponse ()
    {
        return RestResponse;
    }

    public void setRestResponse (RestResponse restResponse)
    {
        this.RestResponse = restResponse;
    }

    public String getMessage() {
        return RestResponse.getMessages().length > 0? RestResponse.getMessages()[0] : "";
    }

    public GroupKtCountryModel[] getContent() {
        return RestResponse.getResult();
    }

    @Override
    public String toString()
    {
        return "ClassPojo [RestResponse = "+ RestResponse +"]";
    }

    public class RestResponse
    {
        private GroupKtCountryModel[] result;
        private String[] messages;

        public RestResponse(String[] messages) {
            this.messages = messages;
        }

        public GroupKtCountryModel[] getResult ()
        {
            return result;
        }

        public void setResult (GroupKtCountryModel[] result)
        {
            this.result = result;
        }

        public String[] getMessages ()
        {
            return messages;
        }

        public void setMessages (String[] messages)
        {
            this.messages = messages;
        }
    }

}