package com.dio.wellingtonmartinho.citiesapi.countries;

import com.dio.wellingtonmartinho.citiesapi.countries.Country;
import com.dio.wellingtonmartinho.citiesapi.countries.repository.CountryRepository;
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
public class ContryResource {


    private CountryRepository repository;

    public ContryResource(CountryRepository repository) {
        this.repository = repository;
    }

    //Solicita ao string uma paginação com todos os países
    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll(page);
    }

    //Solicita ao string uma paginação com um único pais com base em seu id.
    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);
        if (optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }

    }
}
