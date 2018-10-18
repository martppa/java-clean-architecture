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

/**
 * <a href="http://www.groupkt.com">GroupKt</a> host's country model,
 * just like the service delivers it for json mapping.
 */
public class GroupKtCountryModel implements CountryEntity {

    private String name;
    private String alpha2_code;
    private String alpha3_code;

    public void setName (String name)
    {
        this.name = name;
    }

    public String getAlpha2_code ()
    {
        return alpha2_code;
    }

    public void setAlpha2_code (String alpha2_code)
    {
        this.alpha2_code = alpha2_code;
    }

    public String getAlpha3_code ()
    {
        return alpha3_code;
    }

    public void setAlpha3_code (String alpha3_code)
    {
        this.alpha3_code = alpha3_code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIsoCode() {
        return alpha2_code;
    }

    @Override
    public String getFlagImageUrl() {
        return ""; //There is no flag in this host
    }
}
