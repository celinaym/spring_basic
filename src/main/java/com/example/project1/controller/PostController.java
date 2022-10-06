package com.example.project1.controller;

import com.example.project1.domain.PostDomain;
import com.example.project1.dto.PostDto;
import com.example.project1.repository.PostRepository;
import com.example.project1.service.PostService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    // 전체 게시글 조회
    // 작성 날짜 기준으로 내림차순 정렬
    @GetMapping("/api/post")
    public List<PostDomain> getPosts() {
        // 하루 전
        LocalDateTime start = LocalDateTime.now().minusDays(1);
        // 현재 날짜 정보
        LocalDateTime end = LocalDateTime.now();
        return postRepository.findAllByOrderByModifiedAtDesc();
    }

    // 세부사항 작성
    // .get을 붙이면 return type -> PostDomain
    // <Optional> 붙여야지만 Null값이 반환되었을 떄 error가 안뜸
    @GetMapping("/api/post/{id}")
    public Optional<PostDomain> findOne(@PathVariable Long id){

        return postRepository.findById(id);
    }

    // 게시글 작성
    @PostMapping("/api/post")
    public PostDomain createPosts(@RequestBody PostDto postDto) {
        // 사용자가 작성한 postDto를 받아와서 postDomain에 저장
        // DB에 반영
        PostDomain postDomain = new PostDomain(postDto);
        postRepository.save(postDomain);
        return postDomain;
    }


    // 게시글 수정
    @PutMapping("/api/post/{id}")
    // 수정할 id, 수정할 내용이 담겨 있는 postDto 가져오기
    public Long modifyPosts(@PathVariable Long id, @RequestBody PostDto postDto) {
        // 업데이트에 관련된 비지니스 로직은 service에서
        return postService.update(id, postDto);

    }

    // 게시글 삭제
    @DeleteMapping("/api/post/{id}")
    public Long deletePosts(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }


}
