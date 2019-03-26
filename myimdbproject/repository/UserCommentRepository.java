package com.example.myimdbproject.repository;

import com.example.myimdbproject.model.UserCommentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Repository
public interface UserCommentRepository extends JpaRepository<UserCommentModel,Long> {

    Page<UserCommentRepository> findByPostId(Long postId, Pageable pageable);

    Optional<UserCommentRepository> findByIdAndPostId(Long id, Long postId);
}
