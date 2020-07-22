package com.example.demo.service;

import com.example.demo.model.BookCategory;
import com.example.demo.model.User;
import com.example.demo.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookCategoryService {
    @Autowired
    BookCategoryRepository bookCatRepo;

    public List<BookCategory> findAll() {
        return bookCatRepo.findAll();
    }


    public boolean saveBookCat(BookCategory body) {
        BookCategory bookCategory;
        try {
            bookCategory = bookCatRepo.save(body);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public boolean updateBookCat(BookCategory body) {
        BookCategory bookCat = bookCatRepo.findById(body.getId());
        if (bookCat != null){
            try {
                bookCatRepo.save(body);
                return true;
            }catch (Exception e){
                return false;
            }
        }else {
            return false;
        }
    }


    public boolean hapusBookCat(int id) {
        BookCategory result = bookCatRepo.findById(id);
        if (result != null){
            try {
                bookCatRepo.delete(result);
                return true;
            }catch (Exception e){
                return false;
            }
        }else {
            return false;
        }
    }


    public ResponseEntity<Map<String, Object>> getAllBookCategoryPage(String search, int page, int size) {
        try {
            List<BookCategory> bookCategories;
            Pageable pageable = PageRequest.of(page,size);

            Page<BookCategory> bookCategoryPage;
            if (search == null) {
                bookCategoryPage = bookCatRepo.findAll(pageable);
            }else {
                bookCategoryPage = bookCatRepo.findByNameContaining(search, pageable);
            }
            bookCategories = bookCategoryPage.getContent();

            if (bookCategories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("bookCategory", bookCategories);
            response.put("currentPage", bookCategoryPage.getNumber());
            response.put("totalItems", bookCategoryPage.getTotalElements());
            response.put("totalPages", bookCategoryPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
