package com.backend.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.demo.dto.BookDto;
import com.backend.demo.model.Book;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    List<Book> books = new ArrayList();

    @GetMapping
    public List<Book> getBooks() {
        return books;
    }

    @PostMapping
    public List<Book> createBook(@RequestBody BookDto bookDto) {
        Book entity = new Book();
        entity.setId(bookDto.getId());
        entity.setTitle(bookDto.getTitle());
        entity.setAuthor(bookDto.getAuthor());
        entity.setIsbn(bookDto.getIsbn());
        books.add(entity);
        return books;
    }
}
