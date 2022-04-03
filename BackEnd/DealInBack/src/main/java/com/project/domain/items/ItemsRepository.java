package com.project.domain.items;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    Page<Items> findByNameContaining(String name);
    Page<Items> findByCategoriesId(Integer categoryId);
    Page<Items> findByNameContainingAndCategoriesId(String name, Integer categoryId);
}
