package com.martppa.data.repository.datasource.provider.rest.framework;

import java.util.Map;

public interface RestFramework {
   <T> T executeGet(Class<T> responseType, String baseUrl, String route, Map<String, String> parameters);
}
