package com.example.myimdbproject.repository;

import com.example.myimdbproject.model.FilmPostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmPostRepository extends JpaRepository<FilmPostModel,Long> {
}
