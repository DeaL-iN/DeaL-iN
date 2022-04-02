package com.project.domain.useritems;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserItemsRepository extends JpaRepository<UserItems, Integer> {
    Boolean existsByUsersIdAndItemsIdAndIsPurchase(Integer userId, Integer itemId, Boolean isPurchase);
    UserItems findLastByUsersIdAndItemsIdAndIsPurchase(Integer userId, Integer itemId, Boolean isPurchase);
}
