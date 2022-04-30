package com.project.domain.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemResDto {

    private Integer itemsId;
    private String photoUrl;
    private String name;
    private Integer sellPrice;
    private Boolean wish;

    public void setWish(Boolean wish) {
        this.wish = wish;
    }

    public ItemResDto(Items item, String photoUrl, Boolean wish) {
        this.itemsId = item.getId();
        this.photoUrl = photoUrl;
        this.name = item.getName();
        this.sellPrice = item.getSellPrice();
        this.wish = wish;
    }

}
