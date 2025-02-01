package com.exampleateffigo.many_to_many_application0.repository;

import com.exampleateffigo.many_to_many_application0.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
