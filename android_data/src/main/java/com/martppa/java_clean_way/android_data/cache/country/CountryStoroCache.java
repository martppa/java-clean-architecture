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

package com.martppa.java_clean_way.android_data.cache.country;

import android.content.Context;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.cache.Country.CountryCache;

import javax.inject.Inject;
import javax.inject.Singleton;

import st.lowlevel.storo.Storo;
import st.lowlevel.storo.StoroBuilder;

@Singleton
public class CountryStoroCache implements CountryCache {

    @Inject
    public CountryStoroCache(Context context) {
        StoroBuilder.configure(5242880L)  // 5 mb
                .setDefaultCacheDirectory(context)
                .initialize();
    }

    @Override
    public boolean hasExpired() {
        return Storo.hasExpired(COUNTRY_LIST_ID).execute();
    }

    @Override
    public void save(CountryEntity[] countryEntities) {
        Storo.put(COUNTRY_LIST_ID, countryEntities).execute();
    }

    @Override
    public CountryEntity[] get() {
        return Storo.get(COUNTRY_LIST_ID, CountryEntity[].class).execute();
    }
}
