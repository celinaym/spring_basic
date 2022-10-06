package com.example.project1.domain;

import com.example.project1.dto.PostDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PostDomain extends TimeStamped{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제목
    @Column(nullable = false)
    private String title;

    // 작성자명
    @Column(nullable = false)
    private String name;

    // 비밀번호
    @JsonIgnore // password 안보이게
    @Column(nullable = false)
    private String password;

    // 작성내용
    @Column(nullable = false)
    private String content;



    public PostDomain(String title, String name, String password, String content) {
        this.name = name;
        this.content = content;
        this.title = title;
        this.password = password;
    }

    public PostDomain(PostDto postDto){
        this.title = postDto.getTitle();
        this.name = postDto.getName();
        this.password = postDto.getPassword();
        this.content = postDto.getContent();
    }

    public void update(PostDto postDto){
        this.title = postDto.getTitle();
        this.name = postDto.getName();
        this.password = postDto.getPassword();
        this.content = postDto.getContent();
    }




}
