package com.apirest_ude.api_rest.Service;

import com.apirest_ude.api_rest.entities.Category;
import com.apirest_ude.api_rest.entities.Order;
import com.apirest_ude.api_rest.repository.Category_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Category_service {
    final Category_repository repository;
        public Category_service(Category_repository category_repository){
            this.repository = category_repository;
        }
    public Category salvar(Category category){
        return repository.save(category);
    }
    public List<Category> getALL(){
        return repository.findAll();
    }
    public Category getbyID(UUID id){
        Optional<Category> category = repository.findById(id);
        return category.get();
    }
}
