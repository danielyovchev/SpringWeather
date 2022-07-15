
package com.example.springexample.Data.DB.Repository;

import com.example.springexample.Data.DB.Entity.Place;
import com.example.springexample.Data.External.Model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByNameAndCountryName(String name, String country);
    boolean existsById(Long id);
}

