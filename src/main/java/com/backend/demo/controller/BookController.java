package com.backend.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.*;

import com.backend.demo.dto.BookDto;
import com.backend.demo.model.Book;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    List<Book> books = new ArrayList<>();

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

    @PutMapping("/{id}")
    public void updateData(@PathVariable("id") Long id, BookDto bookDto){
        try {
            for (Book book : books) {
                if (Objects.equals(book.getId(), id)) {
                    book.setAuthor(bookDto.getAuthor());
                    book.setTitle(bookDto.getTitle());
                    book.setIsbn(bookDto.getIsbn());
                    books.add(book);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDate(@PathVariable("id")Long id){
        try {
            for (Book book : books) {
                if (Objects.equals(book.getId(), id)) {
                    books.remove(book);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
