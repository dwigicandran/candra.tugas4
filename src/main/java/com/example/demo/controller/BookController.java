package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;

    @GetMapping("")
    List<Book> getAllBooks(){return bookRepository.findAll();}

    @PostMapping("")
    public Map<String,Object> addNewBook(@RequestBody Book body){
        Map<String ,Object> result = new HashMap<>();
        if (bookService.saveBook(body)){
            result.put("success", true);
            result.put("message","data berhasil ditambahkan");
        }else {
            result.put("successs",false);
            result.put("message","data gagal ditambahkan");
        }
        return result;
    }

    @DeleteMapping("")
        //id dr param postman
    Map<String,Object>deleteBook(@RequestParam int id){
        Map<String,Object> result = new HashMap<>();
        if (bookService.hapusBook(id)) {
            result.put("success", true);
            result.put("message", "User Deleted!");
        } else{
            result.put("success", false);
            result.put("message", "User Not Deleted!");
        } return result;
    }

    @PutMapping("")
    Map<String,Object>updateBook(@RequestBody Book body){
        System.out.println("body : " + body.toString());
        Map<String,Object> result = new HashMap<>();

        if (bookService.updateBook(body)) {
            result.put("success", true);
            result.put("message", "User Updated!");
        } else{
            result.put("success", false);
            result.put("message", "User Not Updated!");
        }
        return result;
    }




}
