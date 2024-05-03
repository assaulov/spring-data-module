package ru.edu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.springdata.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
