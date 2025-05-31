package com.derec.nexus_solutions_plataform.service;

import com.derec.nexus_solutions_plataform.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public static List<Product> products = List.of(new Product(1L, "Cano pvc"));

    public void list(){
        System.out.println(products.toString());
    }
}
