package com.example.project1.service;

import com.example.project1.domain.PostDomain;
import com.example.project1.dto.PasswordDto;
import com.example.project1.dto.PostDto;
import com.example.project1.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor    // final로 선언된 멤버 변수를 자동으로 생성
@Service    // 서비스임을 선언
public class PostService {

    private final PostRepository postRepository;

  @Transactional
    // 세부 게시글 파악
    public PostDomain getDetail(Long id, PostDto postDto){
        PostDomain postDomain = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시물이 존재하지 않습니다")
        );
        return postDomain;
    }

    @Transactional
    // 게시글 수정
    // 제목, 작성자명, 비밀번호, 작성 내용 수정
    public Long update(Long id, PostDto postDto) {
        PostDomain postDomain = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 게시물이 존재하지 않습니다")
        );
        postDomain.update(postDto);
        return id;
    }

    @Transactional
    // pw 비교
    public boolean comparePw(Long id, PasswordDto passwordDto) {
        PostDomain postDomain = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("비밀번호가 일치하지 않습니다.")
        );
//        System.out.println(postDomain.getPassword());
//        System.out.println(postDto.getPassword());
        return postDomain.getPassword().equals(passwordDto.getMyPassword());

    }
}



