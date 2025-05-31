package com.derec.nexus_solutions_plataform.repository;

import com.derec.nexus_solutions_plataform.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
}
