package com.project.domain.items;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
    Page<Items> findByNameContaining(String name, Pageable pageable);
    Page<Items> findByCategoriesId(Integer categoryId, Pageable pageable);
    Page<Items> findByNameContainingAndCategoriesId(String name, Integer categoryId, Pageable pageable);
}
