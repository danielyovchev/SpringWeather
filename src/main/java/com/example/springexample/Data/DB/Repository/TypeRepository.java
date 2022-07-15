package com.example.springexample.Data.DB.Repository;

import com.example.springexample.Data.DB.Entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long>{
    Type findByDescription(String name);
}
