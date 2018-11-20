/*
 *   Copyright (c) 2018 Humberto Martín Dieppa, Open source project
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.martppa.java_clean_way.iosapp_data.cache.country;

import com.martppa.java_clean_way.iosapp_data.cache.CustomMultiOSCache;
import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.cache.country.CountryCache;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CountryCustomCache implements CountryCache {
    private CustomMultiOSCache<CountryEntity[]> cache;

    @Inject
    public CountryCustomCache() {
        cache = new CustomMultiOSCache<>();
    }

    @Override
    public boolean hasExpired() {
        return cache.hasExpired(COUNTRY_LIST_ID);
    }

    @Override
    public void save(CountryEntity[] countryEntities) {
        cache.put(COUNTRY_LIST_ID, countryEntities);
    }

    @Override
    public CountryEntity[] get() {
        return cache.get(COUNTRY_LIST_ID);
    }
}
