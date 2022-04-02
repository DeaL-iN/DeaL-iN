package com.project.domain.useritems;

import com.project.domain.items.Items;
import com.project.domain.users.Users;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer price;

    private LocalDateTime dealDate;

    private Boolean isPurchase;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Items items;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

    public void rebidItem(Integer price, LocalDateTime dealDate) {
        this.price = price;
        this.dealDate = dealDate;
    }

    @Builder
    public UserItems(Items items, Users users, Integer price, LocalDateTime dealDate, Boolean isPurchase) {
        this.items = items;
        this.users = users;
        this.price = price;
        this.dealDate = dealDate;
        this.isPurchase = isPurchase;
    }

}
