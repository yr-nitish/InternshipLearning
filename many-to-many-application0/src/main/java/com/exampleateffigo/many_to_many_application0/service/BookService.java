package com.exampleateffigo.many_to_many_application0.service;

import com.exampleateffigo.many_to_many_application0.entity.Author;
import com.exampleateffigo.many_to_many_application0.entity.Book;
import com.exampleateffigo.many_to_many_application0.repository.AuthorRepository;
import com.exampleateffigo.many_to_many_application0.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookDetailsById(long id)
    {
        return bookRepository.findById(id);
    }

    public Book addBookDetails(Book book)
    {
        List<Author> savedAuthors = authorRepository.saveAll(book.getAuthorList());
        book.setAuthorList(savedAuthors);
        return bookRepository.save(book);
    }
}
