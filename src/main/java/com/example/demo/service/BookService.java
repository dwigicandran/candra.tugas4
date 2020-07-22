package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookCategory;
import com.example.demo.model.User;
import com.example.demo.repository.BookCategoryRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookCategoryRepository bookCatRepo;

    public boolean saveBook(Book body) {

            try {
                bookRepository.save(body);
                return true;
            }catch (Exception e){
                return false;
            }
    }


    public boolean hapusBook(int id) {
        Book result = bookRepository.findById(id);
        if (result != null) {
            try {
                bookRepository.delete(result);
                return true;
            } catch (Exception e) {
                return false;
            }

        } else {
            return false;
        }
    }

    public boolean updateBook(Book body) {
        Book bookResult = bookRepository.findById(body.getId());
        BookCategory bc = body.getBookCategory();
        if (bookResult != null) {
            try {
                bookRepository.save(body);
                bookCatRepo.save(bc);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
        }
        return false;
    }
}
