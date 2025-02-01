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
@Table(name = "book_mtm")
public class Book {

    @Id
    private long bookId;
    private String bookTitle;

    @ManyToMany
    private List<Author> authorList = new ArrayList<>();
}
