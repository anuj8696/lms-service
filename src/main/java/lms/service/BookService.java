package lms.service;

import lms.model.Book;
import lms.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepository;

    public Book saveBooks(Book book){
       return bookRepository.save(book);
    }

    public List<Book> findAllBook(){
       return bookRepository.findAll();
    }

    public Book findByBookId(String bookId){
        return bookRepository.findByBookId(bookId);
    }
}
