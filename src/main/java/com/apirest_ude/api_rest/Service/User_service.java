package com.apirest_ude.api_rest.Service;

import com.apirest_ude.api_rest.entities.User;
import com.apirest_ude.api_rest.repository.User_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class User_service {
    final User_repository repository;
        public User_service(User_repository user_repository){
            this.repository = user_repository;
        }
        public User salvar(User user){
            return repository.save(user);
        }
        public List<User> getALL(){
            return repository.findAll();
        }

        public User getbyID(UUID id){
            Optional<User> user = repository.findById(id);
            return user.get();
        }
}
