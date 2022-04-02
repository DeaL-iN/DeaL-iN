package com.project.controller;

import com.project.domain.items.ItemDetailResDto;
import com.project.domain.items.ItemResDto;
import com.project.domain.items.ItemSaveReqDto;
import com.project.domain.users.Users;
import com.project.domain.userswish.UsersWishReqDto;
import com.project.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("")
    public ResponseEntity createItem(@ApiIgnore Authentication authentication, @RequestBody ItemSaveReqDto itemSaveReqDto) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Integer userId = ((Users)authentication.getPrincipal()).getId();
        itemService.createItem(userId, itemSaveReqDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all/{itemsId}")
    public ResponseEntity<List<ItemResDto>> getItems(@ApiIgnore Authentication authentication, @PathVariable Integer itemsId) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.OK).body(itemService.getItems(null, itemsId));
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItems((Users)authentication.getPrincipal(), itemsId));
    }

//    @GetMapping("/{itemsId}")
//    public ResponseEntity<ItemDetailResDto> getDetailItem(@ApiIgnore Authentication authentication, @PathVariable Integer itemsId) {
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return ResponseEntity.status(HttpStatus.OK).body(itemService.getDetailItems(null, itemsId));
//        }
//    }

    @PostMapping("/wish")
    public ResponseEntity setWishItem(@ApiIgnore Authentication authentication, @RequestBody UsersWishReqDto usersWishReqDto) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Users user = ((Users)authentication.getPrincipal());
        itemService.setWishItem(user, usersWishReqDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
