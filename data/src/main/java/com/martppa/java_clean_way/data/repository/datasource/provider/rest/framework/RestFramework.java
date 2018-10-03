package com.martppa.java_clean_way.data.repository.datasource.provider.rest.framework;

import java.io.IOException;
import java.util.Map;

public interface RestFramework {
   <T> T executeGet(Class<T> responseType, String baseUrl, String route, Map<String, String> parameters) throws IOException;
}
