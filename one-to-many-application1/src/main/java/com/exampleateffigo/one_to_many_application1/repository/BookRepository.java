package com.exampleateffigo.one_to_many_application1.repository;

import com.exampleateffigo.one_to_many_application1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
