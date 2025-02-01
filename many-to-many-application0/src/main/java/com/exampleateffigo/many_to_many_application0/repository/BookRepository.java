package com.exampleateffigo.many_to_many_application0.repository;

import com.exampleateffigo.many_to_many_application0.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
