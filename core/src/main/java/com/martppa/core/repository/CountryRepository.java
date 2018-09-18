package com.martppa.core.repository;

import io.reactivex.Observable;

public interface CountryRepository {
    Observable getCountries();
}
