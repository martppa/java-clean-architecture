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

/**
 * <a href="http://www.groupkt.com">GroupKt</a> response model designed
 * to be parsed from a JSON
 */
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