package com.exampleateffigo.many_to_many_application0.controller;

import com.exampleateffigo.many_to_many_application0.entity.Author;
import com.exampleateffigo.many_to_many_application0.entity.Book;
import com.exampleateffigo.many_to_many_application0.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookmtm")
public class BookController
{
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getbooks()
    {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable long id)
    {
        return bookService.getBookDetailsById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book)
    {
        return bookService.addBookDetails(book);
    }

}
