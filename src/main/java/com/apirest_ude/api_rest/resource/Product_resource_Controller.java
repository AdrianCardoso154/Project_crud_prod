package com.apirest_ude.api_rest.resource;

import com.apirest_ude.api_rest.Service.Product_service;
import com.apirest_ude.api_rest.entities.Order;
import com.apirest_ude.api_rest.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Product")
public class Product_resource_Controller {
    final Product_service service;
        public Product_resource_Controller(Product_service product_service){
            this.service = product_service;
        }

    @PostMapping
    public ResponseEntity<Object> salva_Product(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(product));
    }
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getALL());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findbyId(@PathVariable(name = "id") UUID id){
        Product obj = service.getbyID(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
