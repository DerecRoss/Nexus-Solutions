package com.derec.nexus_solutions_plataform.controller;

import com.derec.nexus_solutions_plataform.model.Product;
import com.derec.nexus_solutions_plataform.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("product")
@RequiredArgsConstructor
@Log4j2
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> list(){
        return new ResponseEntity<>(productService.list(), HttpStatus.OK);
    }

    @GetMapping( path = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) throws BadRequestException {
        return new ResponseEntity<>(productService.findByIdOrThrowBadRequest(id), HttpStatus.OK);
    }

    @GetMapping( path = "/find")
    public ResponseEntity<List<Product>> findByName(@RequestParam String name){
        return new ResponseEntity<>(productService.findByName(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody Product product) throws BadRequestException {
        productService.replace(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
