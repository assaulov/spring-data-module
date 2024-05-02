package ru.edu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.edu.springdata.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}