package com.project.domain.categories;

import com.project.domain.items.Items;
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
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30)
    @NotNull
    private String name;

    @OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
    private List<Items> itemsList = new ArrayList<>();

}
