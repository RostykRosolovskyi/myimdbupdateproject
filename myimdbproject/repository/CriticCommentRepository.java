package com.example.myimdbproject.repository;

import com.example.myimdbproject.model.CriticCommentModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CriticCommentRepository extends JpaRepository<CriticCommentModel,Long> {

    Page<UserCommentRepository> findByPostId(Long postId, Pageable pageable);
    Optional<UserCommentRepository> findByIdAndPostId(Long id, Long postId);
}
