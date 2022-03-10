package com.apirest_ude.api_rest.resource;

import com.apirest_ude.api_rest.Service.User_service;
import com.apirest_ude.api_rest.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/User")
public class User_resource_Controller {
    final User_service service;
        public User_resource_Controller(User_service user_service){
            this.service = user_service;
        }
        @PostMapping
        public ResponseEntity<Object> salva_User(@RequestBody User user){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(user));
        }
        @GetMapping
        public ResponseEntity<List<User>> findAll(){
            return ResponseEntity.status(HttpStatus.OK).body(service.getALL());
        }
        @GetMapping("/{id}")
        public ResponseEntity<Object> findbyId(@PathVariable(name = "id")UUID id){
            User obj = service.getbyID(id);
            return ResponseEntity.status(HttpStatus.OK).body(obj);
        }
}
