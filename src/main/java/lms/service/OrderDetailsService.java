package lms.service;

import lms.dto.request.OrderDetailsRequest;
import lms.dto.response.MessageResponse;
import lms.dto.response.OrderedBookForAStudentResponse;
import lms.model.Book;
import lms.model.OrderDetails;
import lms.repository.OrderDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepo orderDetailsRepository;

    @Autowired
    private BookService bookService;

    public MessageResponse issueBoook(OrderDetailsRequest orderDetailsRequest) {
        MessageResponse messageResponse = new MessageResponse();
        Date date = new Date();
        for(String bookId: orderDetailsRequest.getBookId()) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setRegNo((orderDetailsRequest.getRegNo()));
        orderDetails.setBookId(bookId);
        orderDetails.setIssuedDate(date);
        orderDetails.setReturnDate(null);
        orderDetailsRepository.save(orderDetails);
    }
        messageResponse.setMessage("Successfully issued the books");
        messageResponse.setStatus(200);
        return messageResponse;
}

    public List<OrderedBookForAStudentResponse> getIssueBook(String regNo){
        List<OrderDetails> order=  orderDetailsRepository.findOrderByRegNo(regNo);
        List<OrderedBookForAStudentResponse> orderedResponse=new ArrayList<>();
        for(OrderDetails orderDetails:order){
            OrderedBookForAStudentResponse orderedBookForAStudentResponse = new OrderedBookForAStudentResponse();
            Book book = bookService.findByBookId(orderDetails.getBookId());
            orderedBookForAStudentResponse.setBookId(book.getBookId());
            orderedBookForAStudentResponse.setBookName(book.getBookName());
            orderedBookForAStudentResponse.setBookAuthor(book.getAuthor());
            orderedBookForAStudentResponse.setOrderdDate(orderDetails.getIssuedDate().toString());
            orderedResponse.add(orderedBookForAStudentResponse);
        }
        return orderedResponse;
    }

    public MessageResponse returnBooks(OrderDetailsRequest orderDetailsRequest) {
        MessageResponse messageResponse = new MessageResponse();
        Date date = new Date();
        //List<OrderDetails> order=  orderDetailsRepository.findOrderByRegNo(orderDetailsRequest.getRegNo());
        for(String bookId: orderDetailsRequest.getBookId()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setRegNo((orderDetailsRequest.getRegNo()));
            orderDetails.setBookId(bookId);
            orderDetails.setReturnDate(date);
            orderDetailsRepository.save(orderDetails);
        }
        messageResponse.setMessage("Successfully returned the books");
        messageResponse.setStatus(200);
        return messageResponse;
    }
}
