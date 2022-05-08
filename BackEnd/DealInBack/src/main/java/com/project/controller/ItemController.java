package com.project.controller;

import com.project.domain.items.ItemDetailResDto;
import com.project.domain.items.ItemResDto;
import com.project.domain.items.ItemSaveReqDto;
import com.project.domain.useritems.UserItemsReqDto;
import com.project.domain.useritems.UserItemsUpdateReqDto;
import com.project.domain.users.Users;
import com.project.domain.users.UsersBidsResDto;
import com.project.domain.userswish.UsersWishReqDto;
import com.project.service.ItemService;
import com.project.util.S3Uploader;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final S3Uploader s3Uploader;
    private final ItemService itemService;

    // 이미지 업로드
    @PostMapping("/image")
    public List<String> uploadImage(List<MultipartFile> multipartFiles) throws IOException {
        return s3Uploader.upload(multipartFiles);
    }

    // 이미지 삭제
    @PostMapping("/image/delete")
    public ResponseEntity deleteImage(@RequestParam String fileUrl) {
        s3Uploader.delete(fileUrl);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("")
    public ResponseEntity createItem(@ApiIgnore Authentication authentication, @RequestBody ItemSaveReqDto itemSaveReqDto) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        Integer userId = ((Users) authentication.getPrincipal()).getId();
        itemService.createItem(userId, itemSaveReqDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/search/{itemsId}")
    public ResponseEntity<List<ItemResDto>> searchItems(@ApiIgnore Authentication authentication, @PathVariable Integer itemsId, @RequestParam String keyword, @RequestParam Integer categoryId) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.OK).body(itemService.searchItems(null, itemsId, keyword, categoryId));
        }

        return ResponseEntity.status(HttpStatus.OK).body(itemService.searchItems((Users) authentication.getPrincipal(), itemsId, keyword, categoryId));
    }

    @GetMapping("/{itemsId}")
    public ResponseEntity<ItemDetailResDto> getDetailItem(@ApiIgnore Authentication authentication, @PathVariable Integer itemsId) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.OK).body(itemService.getDetailItems(null, itemsId));
        }

        return ResponseEntity.status(HttpStatus.OK).body(itemService.getDetailItems((Users) authentication.getPrincipal(), itemsId));
    }

    @PostMapping("/wish")
    public ResponseEntity setWishItem(@ApiIgnore Authentication authentication, @RequestBody UsersWishReqDto usersWishReqDto) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Users user = ((Users) authentication.getPrincipal());
        itemService.setWishItem(user, usersWishReqDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{itemsId}/bid")
    public ResponseEntity<Boolean> isBidItem(@ApiIgnore Authentication authentication, @PathVariable Integer itemsId) throws Exception {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Users user = ((Users) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.OK).body(itemService.isBidItem(user, itemsId));
    }

    @PostMapping("/bid")
    public ResponseEntity bidItem(@ApiIgnore Authentication authentication, UserItemsReqDto userItemsReqDto) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Users user = ((Users) authentication.getPrincipal());
        itemService.bidItem(1, user, userItemsReqDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/bid")
    public ResponseEntity rebidItem(@ApiIgnore Authentication authentication, UserItemsReqDto userItemsReqDto) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Users user = ((Users) authentication.getPrincipal());
        itemService.bidItem(2, user, userItemsReqDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/buy")
    public ResponseEntity purchaseItem(@ApiIgnore Authentication authentication, UserItemsUpdateReqDto userItemsUpdateReqDto) throws Exception {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Users user = ((Users) authentication.getPrincipal());
        itemService.buyItem(user, userItemsUpdateReqDto);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{itemsId}")
    public ResponseEntity cancelBuyingItem(@ApiIgnore Authentication authentication, @PathVariable Integer itemsId) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Users user = ((Users) authentication.getPrincipal());
        itemService.cancelBuyingItem(user, itemsId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{itemsId}/bids")
    public ResponseEntity<UsersBidsResDto> getNextBiddingUser(@ApiIgnore Authentication authentication, @PathVariable Integer itemsId) {
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }

        Users user = ((Users) authentication.getPrincipal());
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getNextBiddingUser(user, itemsId));
    }

}
