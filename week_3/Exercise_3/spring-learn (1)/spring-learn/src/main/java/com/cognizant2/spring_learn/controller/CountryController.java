package com.cognizant2.spring_learn.controller;

import java.util.List;

import com.cognizant2.spring_learn.model.Country;
import com.cognizant2.spring_learn.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CountryController {

    @Autowired
    private CountryService service;

    @GetMapping("/country")
    public Country getCountryIndia() {

        return service.getCountry("IN");

    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {

        return service.getAllCountries();

    }

    @GetMapping("/countries/{code}")
    public Country getCountry(@PathVariable String code) {

        return service.getCountry(code);

    }

}