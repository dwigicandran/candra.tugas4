package com.example.demo.service;

import com.example.demo.model.BookCategory;
import com.example.demo.repository.BookCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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



}
