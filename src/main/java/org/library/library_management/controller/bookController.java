package org.library.library_management.controller;

import java.util.List;

import org.library.library_management.dto.book;
import org.library.library_management.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class bookController {

    @Autowired
    bookService service;

    /*To Add Data*/
    //To Add Single Book Value
    @PostMapping("/books")
    public ResponseEntity<Object> addBook(@RequestBody book book){
        return service.addBook(book);
    }

    //To Add Multiple Book Values    
    @PostMapping("/books/multiple")
    public ResponseEntity<Object> addBooks(@RequestBody List<book> books){
        return service.addBooks(books);
    }






    /*To Fetch Data*/
    //To Fetch All Book Values
    @GetMapping("/books")
    public ResponseEntity<Object> getAllBooks(){
        return service.getAllBooks();
    }

    //To Fetch book by its id
    @GetMapping("/books/{bookId}")
    public ResponseEntity<Object> getBookById(@PathVariable String bookId){
        return service.getBookById(bookId);
    }

    //To Fetch book by the availability
    @GetMapping("/books/available/{isAvailable}")
    public ResponseEntity<Object> getBooksByAvailability(@PathVariable boolean isAvailable){
        return service.getBooksByAvailability(isAvailable);
    }
    



    /*To Delete Records*/
    //To Delete book by its id
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable String bookId){
        return service.deleteBook(bookId);
    }
}
