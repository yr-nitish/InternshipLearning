package com.exampleateffigo.one_to_many_application1.controller;

import com.exampleateffigo.one_to_many_application1.entity.Book;
import com.exampleateffigo.one_to_many_application1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getthibook(@PathVariable int id)
    {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book addnewbook(@RequestBody Book book)
    {
        return bookService.addBook(book);
    }

}
