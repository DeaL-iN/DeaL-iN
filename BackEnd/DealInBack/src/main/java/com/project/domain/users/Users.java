package com.project.domain.users;

import com.project.domain.common.BaseTimeEntity;
import com.project.domain.items.Items;
import com.project.domain.useritems.UserItems;
import com.project.domain.userswish.UsersWish;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Users extends BaseTimeEntity implements UserDetails {

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

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Items> itemsList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<UserItems> userItemsList = new ArrayList<>();

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<UsersWish> usersWishList = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return this.id.toString();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }
}
