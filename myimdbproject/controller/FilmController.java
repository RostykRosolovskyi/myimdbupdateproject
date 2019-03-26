package com.example.myimdbproject.controller;

import com.example.myimdbproject.exception.ResourceNotFoundException;
import com.example.myimdbproject.model.FilmPostModel;
import com.example.myimdbproject.repository.FilmPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FilmController {
    @Autowired
    private FilmPostRepository filmPostRepository;

    @GetMapping("/findAllFilmPosts")
    public Page<FilmPostModel> getAllPosts(Pageable pageable) {
        return filmPostRepository.findAll(pageable);
    }

    @PostMapping("/createFilmPost")
    public FilmPostModel createFilmPost(@Valid @RequestBody FilmPostModel filmPostModel) {
        return filmPostRepository.save(filmPostModel);
    }

    @PutMapping("/updateposts/{postId}")
    public FilmPostModel updateFilmPost(@PathVariable Long postId, @Valid @RequestBody FilmPostModel filmPostRequest) {
        return filmPostRepository.findById(postId).map(filmPostModel -> {
            filmPostModel.setTitle(filmPostRequest.getTitle());
            filmPostModel.setDescription(filmPostRequest.getDescription());
            filmPostModel.setContent(filmPostRequest.getContent());
            return filmPostRepository.save(filmPostModel);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));

    }

    @DeleteMapping("/deleteFilmPost/{postId}")
    public ResponseEntity deleteFilmPost(@PathVariable Long postId) {
        return filmPostRepository.findById(postId).map(filmPostModel -> {
            filmPostRepository.delete(filmPostModel);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
}
