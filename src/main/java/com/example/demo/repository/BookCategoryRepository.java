package com.example.demo.repository;

import com.example.demo.model.BookCategory;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCategoryRepository extends JpaRepository<BookCategory,Integer> {

    BookCategory findById(int id);
    Page<BookCategory> findByNameContaining(String search, Pageable pageable);
}
