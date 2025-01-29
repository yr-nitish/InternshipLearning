package com.exampleateffigo.one_to_many_application1.services;

import com.exampleateffigo.one_to_many_application1.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> getAllBooks();

    Optional<Book> getBookById(int id);

    Book addBook(Book book);
}
