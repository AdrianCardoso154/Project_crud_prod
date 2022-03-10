package com.apirest_ude.api_rest.repository;

import com.apirest_ude.api_rest.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface Category_repository extends JpaRepository<Category, UUID> {
}
