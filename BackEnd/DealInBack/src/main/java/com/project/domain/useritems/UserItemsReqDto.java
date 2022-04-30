package com.project.domain.useritems;

import com.project.domain.items.Items;
import com.project.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserItemsReqDto {

    private Integer itemId;
    private Integer price;
    private LocalDateTime dealDate;

    public UserItems toEntity(Items item, Users user) {
        return UserItems.builder()
                .items(item)
                .users(user)
                .price(price)
                .dealDate(dealDate)
                .isPurchase(false)
                .build();
    }

}
