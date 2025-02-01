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
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Author> getAllAuthors()
    {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorDetailsById(long id)
    {
        return authorRepository.findById(id);
    }

    public Author addAuthorDetails(Author author)
    {
        List<Book> savedBooks = bookRepository.saveAll(author.getBookList());
        author.setBookList(savedBooks);
        return authorRepository.save(author);
    }
}
