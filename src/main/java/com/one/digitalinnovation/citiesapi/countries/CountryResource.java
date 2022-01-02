package com.one.digitalinnovation.citiesapi.countries;
import com.one.digitalinnovation.citiesapi.countries.entities.Country;
import com.one.digitalinnovation.citiesapi.countries.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResource {

    @Autowired //Para injetar o repositorio (poderia ser também feito com o auxilio de construtor);
    private CountryRepository repository;
    //public CountryResource(CountryRepository repository) { this.repository = repository; }

    /*@GetMapping
    public List<Country> countries() {
        return repository.findAll(); //O repositorio devolve uma lista de paises (findAll);
    }*/
    @GetMapping
    public Page<Country> countries(Pageable page) {
        return repository.findAll(page); //O repositorio devolve uma pagina;
    }
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id) {
        Optional<Country> optional = repository.findById(id); //findById: retorna um optional (true/false);
        if(optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
