package com.exampleateffigo.many_to_many_application0.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "author_mtm")
public class Author {

    @Id
    private long authorId;
    private String authorName;

    @ManyToMany
    private List<Book> bookList = new ArrayList<>();
}
