package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookCategory;
import com.example.demo.repository.BookCategoryRepository;
import com.example.demo.repository.BookRepository;
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

    public ResponseEntity<Map<String, Object>> getAllTitle(String search, int page, int size) {
        try {
            List<Book> books = new ArrayList<>();
            Pageable pageable = PageRequest.of(page,size);

            Page<Book> bookPage;
            if (search == null) {
                bookPage = bookRepository.findAll(pageable);
            }else {
                bookPage = bookRepository.findByTitleContaining(search, pageable);
            }
            books = bookPage.getContent();

            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            Map<String, Object> response = new HashMap<>();
            response.put("books", books);
            response.put("currentPage", bookPage.getNumber());
            response.put("totalItems", bookPage.getTotalElements());
            response.put("totalPages", bookPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public List<Book> getAllBookByTitle(String title) {
        return bookRepository.findByTitleContaining(title);
    }

//    public List<Book> getAllBookByCategory(int id) {
//        return bookRepository.findBycategoryidContaining(id);
//    }
}
