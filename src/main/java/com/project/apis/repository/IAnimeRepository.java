package com.project.apis.repository;

import com.project.apis.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAnimeRepository extends JpaRepository<Anime, Long > {
    Optional<Anime> findByTitle(String title);
    Optional<Anime> findByAuthor(String author);

}
