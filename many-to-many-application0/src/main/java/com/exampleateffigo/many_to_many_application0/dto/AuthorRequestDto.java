package com.exampleateffigo.many_to_many_application0.dto;

import com.exampleateffigo.many_to_many_application0.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequestDto {
    private long authorId;
    private String authorName;
    private List<Book> bookList;
}
