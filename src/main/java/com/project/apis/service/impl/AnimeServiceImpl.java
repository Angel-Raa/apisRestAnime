package com.project.apis.service.impl;

import com.project.apis.exception.ResourceNotFound;
import com.project.apis.models.Anime;
import com.project.apis.repository.IAnimeRepository;
import com.project.apis.service.IAnimeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AnimeServiceImpl implements IAnimeService {
    @Autowired
    private IAnimeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<Anime>> findAllAnime() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<Anime> anime(Long id) {
        Optional<Anime> anime = repository.findById(id);
        if (anime.isPresent()) {
            Anime animeId = anime.get();
            return ResponseEntity.ok(animeId);
        } else {
            throw new ResourceNotFound("that id does not exist", id.toString());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<Optional<Anime>> findByTitle(String title) {
        Optional<Anime> anime = repository.findByTitle(title);
        if (anime.isPresent()) {
            return ResponseEntity.ok(anime);
        }
        throw new ResourceNotFound("message", "Anime not found");
    }

    @Override
    @Transactional
    public ResponseEntity<Optional<Anime>> findByAuthor(String author) {
        Optional<Anime> anime = repository.findByAuthor(author);
        if (anime.isPresent()) {
            return ResponseEntity.ok(anime);
        }
        throw new ResourceNotFound("message", "author not found");
    }

    @Override
    @Transactional
    public ResponseEntity<Anime> saveAnime(Anime anime) {
        return new ResponseEntity<>(repository.save(anime), HttpStatus.CREATED);
    }

    @Override
    @Transactional
    public ResponseEntity<Anime> updateAnime(Long id, Anime anime) {
        Anime animeToUpdate = repository.findById(id).orElseThrow(() -> new ResourceNotFound("message" , "Not found anime".concat(id.toString())));
        BeanUtils.copyProperties(anime,animeToUpdate, "id");
        Anime update = repository.save(animeToUpdate);
        return ResponseEntity.ok(update);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteAnime(Long id) {
        Map<String, Object> response = new HashMap<>();
        Optional<Anime> anime = repository.findById(id);
        if (anime.isPresent()) {
            repository.deleteById(id);
            response.put("message", "Anime deleted successfully");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        response.put("message", "not found");
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }
}
