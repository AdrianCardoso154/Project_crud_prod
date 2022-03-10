package com.apirest_ude.api_rest.resource;

import com.apirest_ude.api_rest.Service.Category_service;
import com.apirest_ude.api_rest.entities.Category;
import com.apirest_ude.api_rest.entities.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Category")
public class Category_resource_Controller {
    final Category_service service;
        public Category_resource_Controller(Category_service category_service){
            this.service = category_service;
        }
    @PostMapping
    public ResponseEntity<Object> salva_Category(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(category));
    }
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getALL());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findbyId(@PathVariable(name = "id") UUID id){
        Category obj = service.getbyID(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }
}
