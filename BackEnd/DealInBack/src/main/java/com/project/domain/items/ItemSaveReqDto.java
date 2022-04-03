package com.project.domain.items;

import com.project.domain.categories.Categories;
import com.project.domain.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemSaveReqDto {

    private String name;
    private String categoryName;
    private Integer startPrice;
    private Integer sellPrice;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime deadlineDate;
    private String contents;

    private List<String> photos = new ArrayList<>();

    public Items toEntity(Users user, Categories categories) {
        return Items.builder()
                .name(name)
                .users(user)
                .categories(categories)
                .startPrice(startPrice)
                .sellPrice(sellPrice)
                .deliveryStatus(deliveryStatus)
                .deadlineDate(deadlineDate)
                .contents(contents)
                .isClosed(false)
                .build();
    }


}
