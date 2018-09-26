package com.martppa.java_clean_way.core.repository;

import io.reactivex.Observable;

public interface CountryRepository {
    Observable getCountries();
}
