package com.exampleateffigo.one_to_many_application1.services;

import com.exampleateffigo.one_to_many_application1.entity.Book;
import com.exampleateffigo.one_to_many_application1.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id)
    {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book)
    {
            return bookRepository.save(book);
    }
}
