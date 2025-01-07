package org.library.library_management.controller;

import java.util.List;

import org.library.library_management.dto.book;
import org.library.library_management.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;



@RestController
public class bookController {

    @Autowired
    bookService service;

    /*To Add Data*/
    @Operation(summary = "Saving or Creating The library book Record", description = "To Create a new Book Record")
    @ApiResponse(responseCode = "201", description = "Successfully Created")
    @ApiResponse(responseCode = "226", description = "Book Data Already Exists")
    @PostMapping("/books")
    public ResponseEntity<Object> addBook(@RequestBody book book){
        return service.addBook(book);
    }

    @Operation(summary = "Saving or Creating Multiple library book Records", description = "To Create a new Book Record")
    @ApiResponse(responseCode = "201", description = "Successfully Created")
    @ApiResponse(responseCode = "226", description = "Book Data Already Exists")    
    @PostMapping("/books/multiple")
    public ResponseEntity<Object> addBooks(@RequestBody List<book> books){
        return service.addBooks(books);
    }






    /*To Fetch Data*/
    @Operation(summary = "Fetching All the book Records", description = "To Fetch All Book Records")
    @ApiResponse(responseCode = "302", description = "Successfully Fetched")
    @ApiResponse(responseCode = "404", description = "No Books Available")
    @GetMapping("/books")
    public ResponseEntity<Object> getAllBooks(){
        return service.getAllBooks();
    }

    @Operation(summary = "Fetching  book Record by it's BookId", description = "To Fetch All Book Records with BookId")
    @ApiResponse(responseCode = "302", description = "Successfully Fetched")
    @ApiResponse(responseCode = "404", description = "No Books Available with the BookId")
    @GetMapping("/books/{bookId}")
    public ResponseEntity<Object> getBookById(@PathVariable String bookId){
        return service.getBookById(bookId);
    }

    @Operation(summary = "Fetching  book Record by it's Availability", description = "To Fetch All Book Records By it's Availability")
    @ApiResponse(responseCode = "302", description = "Successfully Fetched")
    @ApiResponse(responseCode = "404", description = "Books Data Not Found")
    @GetMapping("/books/available/{isAvailable}")
    public ResponseEntity<Object> getBooksByAvailability(@PathVariable boolean isAvailable){
        return service.getBooksByAvailability(isAvailable);
    }
    



    /*To Delete Records*/
    @Operation(summary = "Deleting book Record by it's BookId", description = "To Delete the Book Record with BookId")
    @ApiResponse(responseCode = "200", description = "Successfully Deleted")
    @ApiResponse(responseCode = "406", description = "No Book Data With The Particular BookId")
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable String bookId){
        return service.deleteBook(bookId);
    }


    /*To Update Records */
    @Operation(summary = "Fetching  book Record by it's BookId", description = "To Fetch All Book Records with BookId")
    @ApiResponse(responseCode = "202", description = "Successfully Updated")
    @ApiResponse(responseCode = "406", description = "Books Record Failed to Fetch and update Record")
    @PatchMapping("/books/{bookId}")
    public ResponseEntity<Object> updateBook(@PathVariable String bookId, @RequestBody book book) {
        return service.updateBook(bookId, book);
    }
}
