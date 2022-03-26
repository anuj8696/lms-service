package lms.dto.response;

public class OrderedBookForAStudentResponse {

    private String bookId;
    private String bookName;
    private String bookAuthor;
    private String orderdDate;

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

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getOrderdDate() {
        return orderdDate;
    }

    public void setOrderdDate(String orderdDate) {
        this.orderdDate = orderdDate;
    }
}
