package com.exampleateffigo.many_to_many_application0.controller;

import com.exampleateffigo.many_to_many_application0.dto.AuthorRequestDto;
import com.exampleateffigo.many_to_many_application0.entity.Author;
import com.exampleateffigo.many_to_many_application0.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authormtm")
public class AuthorController
{
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors()
    {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Optional<Author> getAuthorById(@PathVariable long id)
    {
        return authorService.getAuthorDetailsById(id);
    }

    @PostMapping
    public Author addAuthor(@RequestBody AuthorRequestDto authorRequestDto)
    {
        Author newAuthor = new Author();
        newAuthor.setAuthorId(authorRequestDto.getAuthorId());
        newAuthor.setAuthorName(authorRequestDto.getAuthorName());
        newAuthor.setBookList(authorRequestDto.getBookList());
        return authorService.addAuthorDetails(newAuthor);
    }
}
