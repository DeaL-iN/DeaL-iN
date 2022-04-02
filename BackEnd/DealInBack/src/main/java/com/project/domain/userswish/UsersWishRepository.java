package com.project.domain.userswish;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersWishRepository extends JpaRepository<UsersWish, Integer> {
    Boolean existsByUsersIdAndItemsId(Integer userId, Integer itemId);
    void deleteByUsersIdAndItemsId(Integer userId, Integer itemId);
}
