package com.dio.wellingtonmartinho.citiesapi.countries.repository;

import com.dio.wellingtonmartinho.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
