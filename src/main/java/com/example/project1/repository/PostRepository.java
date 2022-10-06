package com.example.project1.repository;

import com.example.project1.domain.PostDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostDomain, Long> {
    List<PostDomain> findAllByOrderByModifiedAtDesc();
}
