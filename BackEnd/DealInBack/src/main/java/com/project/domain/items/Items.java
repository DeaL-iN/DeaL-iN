package com.project.domain.items;

import com.project.domain.categories.Categories;
import com.project.domain.common.BaseTimeEntity;
import com.project.domain.itemphotos.ItemPhotos;
import com.project.domain.useritems.UserItems;
import com.project.domain.users.Users;
import com.project.domain.userswish.UsersWish;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Items extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    @NotNull
    private String name;

    @NotNull
    private Integer startPrice;

    @NotNull
    private Integer sellPrice;

    @Enumerated(EnumType.STRING)
    @NotNull
    private DeliveryStatus deliveryStatus;

    @NotNull
    private LocalDateTime deadlineDate;

    @Column(length = 255)
    @NotNull
    private String contents;

    private Boolean isClosed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Categories categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Users users;

    @OneToMany(mappedBy = "items", cascade = CascadeType.ALL)
    private List<ItemPhotos> itemPhotosList = new ArrayList<>();

    @OneToMany(mappedBy = "items", cascade = CascadeType.ALL)
    private List<UserItems> userItemsList = new ArrayList<>();

    @OneToMany(mappedBy = "items", cascade = CascadeType.ALL)
    private List<UsersWish> usersWishList = new ArrayList<>();

    public void setClosedStatus(Boolean isClosed) {
        this.isClosed = isClosed;
    }

    @Builder
    public Items(Integer id, @NotNull String name, @NotNull Integer startPrice, @NotNull Integer sellPrice, @NotNull DeliveryStatus deliveryStatus, @NotNull LocalDateTime deadlineDate, @NotNull String contents, Boolean isClosed, Categories categories, Users users) {
        this.id = id;
        this.name = name;
        this.startPrice = startPrice;
        this.sellPrice = sellPrice;
        this.deliveryStatus = deliveryStatus;
        this.deadlineDate = deadlineDate;
        this.contents = contents;
        this.isClosed = isClosed;
        this.categories = categories;
        this.users = users;
    }
}
