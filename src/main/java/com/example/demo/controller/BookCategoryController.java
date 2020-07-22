package com.example.demo.controller;

import com.example.demo.model.BookCategory;
import com.example.demo.repository.BookCategoryRepository;
import com.example.demo.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("bookcategory")
public class BookCategoryController {
    @Autowired
    BookCategoryRepository bookCatRepo;
    @Autowired
    BookCategoryService bookCatService;

    @GetMapping("")
    List<BookCategory> getAllBookCategory(){
        return bookCatService.findAll();
    }

    @PostMapping("")
    public Map<String,Object>addNewBookCat(@RequestBody BookCategory body){
        Map<String,Object> result = new HashMap<>();
        if (bookCatService.saveBookCat(body)){
            result.put("success",true);
            result.put("message","Data berhasil ditambahkan");
        }else {
            result.put("success",false);
            result.put("message","data gagal ditambahkan");
        }
        return result;
    }

    @PutMapping("")
    public Map<String,Object> updateBookCat(@RequestBody BookCategory body){
        Map<String,Object> result = new HashMap<>();
        if (bookCatService.updateBookCat(body)){
            result.put("success",true);
            result.put("message","Data berhasil diubah");
        }else {
            result.put("success",false);
            result.put("message","Data gagal diubah");
        }
        return result;
    }

    @DeleteMapping("")
    Map<String,Object>deleteBookCat(@RequestParam int id){
        Map<String,Object> result = new HashMap<>();
        if (bookCatService.hapusBookCat(id)) {
            result.put("success", true);
            result.put("message", "Data berhasil dihapus");
        } else{
            result.put("success", false);
            result.put("message", "Data gagal dihapus");
        } return result;
    }

    @GetMapping("/page")
    public ResponseEntity<Map<String ,Object>> getAllBookCat(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size )
    { return bookCatService.getAllBookCategoryPage(search,page,size); }







}
