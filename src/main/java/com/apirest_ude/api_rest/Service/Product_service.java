package com.apirest_ude.api_rest.Service;

import com.apirest_ude.api_rest.entities.Product;
import com.apirest_ude.api_rest.repository.Product_reposytory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Product_service {
    final Product_reposytory repository;
        public Product_service(Product_reposytory product_reposytory){
            this.repository = product_reposytory;
        }
    public Product salvar(Product product){
        return repository.save(product);
    }
    public List<Product> getALL(){
        return repository.findAll();
    }
    public Product getbyID(UUID id){
        Optional<Product> product = repository.findById(id);
        return product.get();
    }
}
