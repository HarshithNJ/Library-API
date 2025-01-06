package org.library.library_management.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.library.library_management.dto.book;
import org.library.library_management.repository.bookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class bookService {

    @Autowired
    bookRepository repository;

    public ResponseEntity<Object> addBook(book book) {
        if(repository.existsByBookId(book.getBookId())){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Book Already Exists with the id : " + book.getBookId());

            return new ResponseEntity<Object>(map, HttpStatus.IM_USED);
        }else{
            repository.save(book);
            
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sucess", "Record saved Successfully");
            map.put("Data", book);

            return new ResponseEntity<Object>(book, HttpStatus.CREATED);
        }
    }



    public ResponseEntity<Object> getAllBooks() {
        List<book> books = repository.findAll();
        if(repository.findAll().isEmpty()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "No Books Found");

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sucess", "Record saved Successfully");
            map.put("Data", books);

            return new ResponseEntity<Object>(books, HttpStatus.OK);
        }
    }


    public ResponseEntity<Object> addBooks(List<book> books) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addBooks'");
    }


    public ResponseEntity<Object> getBookById(String bookId) {
        Optional<book> op = repository.findByBookId(bookId);

        if(op.isPresent()){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("sucess", "Book Found");
            map.put("Data", op.get());            

            return new ResponseEntity<Object>(op.get(), HttpStatus.OK);
        }else{
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("error", "Book Not Found with id " + bookId);

            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }
    }

    
}
