package com.project.apis.controller;

import com.project.apis.models.Anime;
import com.project.apis.service.IAnimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/apis")
public class AnimeController {
    @Autowired
    private IAnimeService service;

    @GetMapping("/anime/all")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Anime>> animeList() {
        return service.findAllAnime();
    }


    @GetMapping("/anime/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Anime> anime(@PathVariable Long id){
        return service.anime(id);
    }

    @GetMapping("/anime/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Anime>> animeTitle(@PathVariable("title") String title){
        return service.findByTitle(title);
    }

    @GetMapping("/anime/author/{author}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Optional<Anime>> animeAuthor(@PathVariable("author") String author){
        return service.findByAuthor(author);
    }


    @PostMapping("/anime")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Anime> saveAnime(@Valid @RequestBody Anime anime){
        return service.saveAnime(anime);
    }

    @PutMapping("/anime/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Anime> updateAnime(@Valid @RequestBody Anime anime , @PathVariable Long id){
        return service.updateAnime(id, anime);
    }

    @DeleteMapping("/anime/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> deleteAnime(@PathVariable Long id){
        return service.deleteAnime(id);
    }

}
