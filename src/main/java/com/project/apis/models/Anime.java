package com.project.apis.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "animes")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "field cannot be empty")
    @Column(unique = true)
    private String title;
    private String description;
    @NotEmpty(message = "field cannot be empty")
    private String author;
    private Boolean issue;

}
