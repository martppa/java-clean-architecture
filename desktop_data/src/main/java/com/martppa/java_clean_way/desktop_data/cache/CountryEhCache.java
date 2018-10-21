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

package com.martppa.java_clean_way.desktop_data.cache;

import com.martppa.java_clean_way.data.entities.CountryEntity;
import com.martppa.java_clean_way.data.repository.cache.Country.CountryCache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CountryEhCache implements CountryCache {
    private final Cache cache;

    @Inject
    public CountryEhCache() {
        final CacheManager cacheManager = CacheManager.getInstance();
        cacheManager.addCache(CACHE_ID);
        cache = cacheManager.getCache(CACHE_ID);
    }

    @Override
    public boolean hasExpired() {
        Element element;
        if ((element = cache.get(COUNTRY_LIST_ID)) == null)
            return true;
        return element.isExpired();
    }

    @Override
    public void save(CountryEntity[] countryEntities) {
        cache.put(new Element(COUNTRY_LIST_ID, countryEntities));
    }

    @Override
    public CountryEntity[] get() {
        return (CountryEntity[]) cache.get(COUNTRY_LIST_ID).getObjectValue();
    }
}
