package com.apirest_ude.api_rest.repository;

import com.apirest_ude.api_rest.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface Product_reposytory extends JpaRepository<Product, UUID> {
}
