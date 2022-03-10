package com.apirest_ude.api_rest.Service;

import com.apirest_ude.api_rest.entities.Order;
import com.apirest_ude.api_rest.entities.User;
import com.apirest_ude.api_rest.repository.Order_repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class Order_service {
    final Order_repository repository;
        public Order_service(Order_repository order_repository){
            this.repository = order_repository;
        }
    public Order salvar(Order order){
        return repository.save(order);
    }
    public List<Order> getALL(){
        return repository.findAll();
    }
    public Order getbyID(UUID id){
        Optional<Order> order = repository.findById(id);
        return order.get();
    }
}
