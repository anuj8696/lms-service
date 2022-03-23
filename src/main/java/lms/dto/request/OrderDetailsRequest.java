package lms.dto.request;

import java.util.List;

public class OrderDetailsRequest {
    private String regNo;
    private List<String> bookId;

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public List<String> getBookId() {
        return bookId;
    }

    public void setBookId(List<String> bookId) {
        this.bookId = bookId;
    }
}
