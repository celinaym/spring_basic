package com.example.project1.controller;

import com.example.project1.dto.PasswordDto;
import com.example.project1.dto.PostDto;
import com.example.project1.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class compareController {

    private final PostService postService;


    // pw 확인
    @PostMapping("/api/post/{id}")
    public boolean comparePw(@PathVariable Long id, @RequestBody PasswordDto passwordDto){
        return postService.comparePw(id, passwordDto);
    }

}
