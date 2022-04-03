package com.project.domain.useritems;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserItemsUpdateReqDto {

    private Integer itemId;
    private Integer price;

}
