package com.backend.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;

    // MANY TO ONE (Book -> Author)
    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonBackReference
    private Author author;

    // MANY TO MANY (Book <-> User)
    @ManyToMany
    @JoinTable(
        name = "book_user",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;
}