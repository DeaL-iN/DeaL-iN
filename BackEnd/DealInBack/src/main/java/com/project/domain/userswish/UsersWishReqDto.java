package com.project.domain.userswish;

import com.project.domain.items.Items;
import com.project.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UsersWishReqDto {

    private Boolean wish;
    private Integer itemId;

    public UsersWish toEntity(Items item, Users user) {
        return UsersWish.builder()
                .items(item)
                .users(user)
                .build();
    }

}
