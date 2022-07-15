package com.example.springexample.Data.DB.Repository;

import com.example.springexample.Data.DB.Entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long>{
    Country findByName(String name);
}
