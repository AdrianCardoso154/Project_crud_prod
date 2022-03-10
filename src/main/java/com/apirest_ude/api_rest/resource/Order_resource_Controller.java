package com.apirest_ude.api_rest.resource;

import com.apirest_ude.api_rest.Service.Order_service;
import com.apirest_ude.api_rest.entities.Order;
import com.apirest_ude.api_rest.entities.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Order")
public class Order_resource_Controller {
    final Order_service service;
        public Order_resource_Controller(Order_service order_service){
            this.service = order_service;
        }
    @PostMapping
    public ResponseEntity<Object> salva_Order(@RequestBody Order order){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(order));
    }
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getALL());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> findbyId(@PathVariable(name = "id") UUID id){
        Order obj = service.getbyID(id);
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

}
