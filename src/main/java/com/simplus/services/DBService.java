package com.simplus.services;

import com.simplus.domain.Company;
import com.simplus.repositories.CompanyRepository;
import com.simplus.repositories.ProductRepository;
import com.simplus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Arrays;

public class DBService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public void instantiateTestDatabase() throws ParseException {

           Company com1 = new Company(null, "Empresa 1");
           Company com2 = new Company(null, "Empresa 2");
           companyRepository.saveAll(Arrays.asList(com1, com2));

    }
}