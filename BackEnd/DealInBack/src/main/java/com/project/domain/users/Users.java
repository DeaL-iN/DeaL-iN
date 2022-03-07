package com.project.domain.users;

import com.project.domain.common.BaseTimeEntity;
import com.project.domain.items.Items;
import com.project.domain.useritems.UserItems;
import com.project.domain.userswish.UsersWish;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    @NotNull
    private String email;

    @Column(length = 20)
    @NotNull
    private String password;

    @Column(length = 10)
    private String name;

    @Column(length = 20)
    @NotNull
    private String nickname;

    @Column(length = 30)
    private String tel;

    @Column(length = 100)
    private String address;

    @Column(length = 100)
    private String addressDetail;

    private Integer point;

    @Column(length = 10)
    private String grade;

    @Column(length = 255)
    private String profileImageUrl;

    private Boolean blacklist;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Items> itemsList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<UserItems> userItemsList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<UsersWish> usersWishList = new ArrayList<>();

}
