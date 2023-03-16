package com.project.apis.service;

import com.project.apis.models.Anime;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IAnimeService {
    ResponseEntity<List<Anime>> findAllAnime();

    ResponseEntity<Anime> anime(Long id);

    ResponseEntity<Optional<Anime>> findByTitle(String title);

    ResponseEntity<Optional<Anime>> findByAuthor(String author);

    ResponseEntity<Anime> saveAnime(Anime anime);

    ResponseEntity<Anime> updateAnime(Long id, Anime anime);

    ResponseEntity<?> deleteAnime(Long id);
}
