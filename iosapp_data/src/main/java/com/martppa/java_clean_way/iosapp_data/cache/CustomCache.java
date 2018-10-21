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

package com.martppa.java_clean_way.iosapp_data.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Very Simple cache implementation
 */
public class CustomCache<T> {
    private Map<String, Element> cacheMap;
    private long cacheLifeTimeInMillis = 3600000; //1 hour

    public CustomCache() {
        cacheMap = new HashMap<>();
    }

    public void put(String id, T object) {
        cacheMap.put(id, new Element(id, object, System.currentTimeMillis()));
    }

    public T get(String id) {
        return cacheMap.get(id).object;
    }

    public boolean hasExpired(String id) {
        Element element;
        if ((element = cacheMap.get(id)) == null)
            return true;
        long createdAt = element.timeOfCreation;
        long currentTime = System.currentTimeMillis();
        return currentTime - createdAt > cacheLifeTimeInMillis;
    }

    private class Element {
        Element(String id, T object, long timeOfCreation) {
            this.id = id;
            this.object = object;
            this.timeOfCreation = timeOfCreation;
        }
        String id;
        T object;
        long timeOfCreation;
    }
}
