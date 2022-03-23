package lms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Book")
public class Book implements Serializable {
    @Id
    @Column(name="bookId", nullable = false)
    private String bookId;
    @Column(name="bookName", nullable = false)
    private String bookName;
    @Column(name="author", nullable = false)
    private String author;
    @Column(name="category", nullable = false)
    private String category;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
