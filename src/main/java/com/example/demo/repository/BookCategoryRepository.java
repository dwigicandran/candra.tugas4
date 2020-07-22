package com.example.demo.repository;

import com.example.demo.model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {

    BookCategory findById(int id);
}
