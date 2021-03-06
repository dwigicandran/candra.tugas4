package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.BookCategory;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findById(int id);

    Page<Book> findByTitleContaining(String search, Pageable pageable);
    List<Book>findByTitleContaining(String title);

    @Query(value = "SELECT * FROM book WHERE categoryid = :id ", nativeQuery = true)
    List<Book>  findBycategoryidContaining(@Param("id") int id);
}
