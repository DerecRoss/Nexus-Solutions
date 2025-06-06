package com.derec.nexus_solutions_plataform.repository;

import com.derec.nexus_solutions_plataform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    List<Product> findByName(String name);
}
