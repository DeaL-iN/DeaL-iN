package com.project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.*;

@RestController
public class TestController {

    @Operation(summary = "test hello", description = "Test api example")
    // @ApiResponses({
    //         @ApiResponse(responseCode = "200", description = "OK"),
    //         @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
    //         @ApiResponse(responseCode = "404", description = "NOT FOUND"),
    //         @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    // })
    @GetMapping("/hello")
    public ResponseEntity<String> hello(@Parameter(description = "이름", required = true, example = "Park") @RequestParam String name) {
        return ResponseEntity.ok("hello " + name);
    }
}