package lms.controller;

import lms.model.Book;
import lms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value="/saveBooks")
    public ResponseEntity<?> saveBooks(@RequestBody Book book){
       return new ResponseEntity<>(bookService.saveBooks(book), HttpStatus.OK);
    }

    @GetMapping(value="/listOfBooks")
    public ResponseEntity<?> listOfBooks(){
       return new ResponseEntity<>(bookService.findAllBook(),HttpStatus.OK);
    }
}
