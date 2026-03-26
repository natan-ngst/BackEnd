package com.backend.demo.service;

import com.backend.demo.dto.BookDto;
import com.backend.demo.model.Author;
import com.backend.demo.model.Book;
import com.backend.demo.repository.AuthorRepository;
import com.backend.demo.repository.BookRepository;
import com.backend.demo.repository.UserRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.backend.demo.model.User;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final UserRepository userRepository;


    @Override
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(BookDto bookDto) {

        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());

        // ambil author
        Author author = authorRepository.findById(bookDto.getAuthorId())
            .orElseThrow(() -> new RuntimeException("Author not found"));

    book.setAuthor(author);

        // ambil user list
        List<User> users = userRepository.findAllById(bookDto.getUserIds());
        book.setUsers(users);

        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, BookDto bookDto) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(bookDto.getTitle());
        book.setIsbn(bookDto.getIsbn());

        // ambil author
        Author author = authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Author not found"));
        book.setAuthor(author);

        // ambil user list
        List<User> users = userRepository.findAllById(bookDto.getUserIds());
        book.setUsers(users);

        return bookRepository.save(book);
    }

    @Override
    public Book getDetail(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.get();
    }

    @Override
    public void delete(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        bookRepository.existsById(id);
        bookRepository.delete(book.get());
    }
}
