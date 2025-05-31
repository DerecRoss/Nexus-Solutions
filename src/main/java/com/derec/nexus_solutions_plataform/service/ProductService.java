package com.derec.nexus_solutions_plataform.service;

import com.derec.nexus_solutions_plataform.model.Product;
import com.derec.nexus_solutions_plataform.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> list(){
        return productRepository.findAll();
    }
}
