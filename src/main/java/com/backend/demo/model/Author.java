package com.backend.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String bio;

    // relasi ke user (1-1)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // relasi ke book (1-n)
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Book> books;
}