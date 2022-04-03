package com.project.domain.useritems;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserItemsRepository extends JpaRepository<UserItems, Integer> {
    Boolean existsByUsersIdAndItemsIdAndIsPurchase(Integer userId, Integer itemId, Boolean isPurchase);
    UserItems findLastByUsersIdAndItemsIdAndIsPurchase(Integer userId, Integer itemId, Boolean isPurchase);
    UserItems findByUsersIdAndItemsIdAndPrice(Integer userId, Integer itemId, Integer price);
    Optional<UserItems> findLastByItemsIdAndIsPurchase(Integer itemId, Boolean isPurchase);
    Long countByItemsIdAndIsPurchase(Integer itemId, Boolean isPurchase);
}
