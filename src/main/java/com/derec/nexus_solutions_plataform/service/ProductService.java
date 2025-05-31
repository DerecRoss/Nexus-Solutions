package com.derec.nexus_solutions_plataform.service;

import com.derec.nexus_solutions_plataform.model.Product;
import com.derec.nexus_solutions_plataform.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> list(){
        return productRepository.findAll();
    }

    public Product findByIdOrThrowBadRequest(Long id) throws BadRequestException {
        return productRepository.findById(id).
                orElseThrow( () -> new BadRequestException("Anime not found."));
    }

    public List<Product> findByName(String name){
       return productRepository.findByName(name);
    }

    @Transactional
    public Product save(Product product){
        product = Product.builder().name(product.getName()).build();
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

    public void replace(Product product) throws BadRequestException {
        Product savedProduct = findByIdOrThrowBadRequest(product.getId());
        product = Product.builder().id(savedProduct.getId()).name(savedProduct.getName()).build();
        productRepository.save(product);
    }
}
