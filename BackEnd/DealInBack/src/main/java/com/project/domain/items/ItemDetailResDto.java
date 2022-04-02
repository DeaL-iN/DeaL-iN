package com.project.domain.items;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetailResDto {

    private String profileImageUrl;
    private String nickname;
    private String grade;
    private Integer startPrice;
    private Integer sellPrice;
    private Integer joinCnt;
    private LocalDateTime deadlineDate;
    private Boolean wish;

    private List<String> photos;

}
