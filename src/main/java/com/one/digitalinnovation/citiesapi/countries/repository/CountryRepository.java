package com.one.digitalinnovation.citiesapi.countries.repository;
import com.one.digitalinnovation.citiesapi.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> { //Classe e Id;
    //Essa interface representa o Country;
}
