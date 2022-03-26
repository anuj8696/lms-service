package lms.repository;

import lms.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepo extends JpaRepository<Book,String> {

    @Query(value = "select * from book where book_id= ?1", nativeQuery = true)
    Book findByBookId(String bookId);
}