
package com.example.springexample.Data.DB.Repository;

import com.example.springexample.Data.DB.Entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {
    Place findByNameAndCountryName(String name, String country);
    List<Place> findAllByName(String name);
    boolean existsById(Long id);
    Optional<Place> findById(Long id);
}

