package com.project.domain.itemphotos;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPhotosRepository extends JpaRepository<ItemPhotos, Integer> {
    ItemPhotos findFirstByItemsId(Integer itemId);
    List<ItemPhotos> findAllByItemsId(Integer itemId);

}
