package com.cognizant2.spring_learn.service;

import java.util.List;

import com.cognizant2.spring_learn.model.Country;
import com.cognizant2.spring_learn.model.CountryList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class CountryService {

    private List<Country> countries;

    public CountryService() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("country.xml");

        CountryList list =
                context.getBean("countryList", CountryList.class);

        countries = list.getCountryList();

    }

    public List<Country> getAllCountries() {

        return countries;

    }

    public Country getCountry(String code) {

        for (Country country : countries) {

            if (country.getCode().equalsIgnoreCase(code)) {

                return country;

            }

        }

        return null;

    }

}