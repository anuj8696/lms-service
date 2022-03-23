package lms.service;

import lms.dto.request.OrderDetailsRequest;
import lms.dto.response.MessageResponse;
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
        messageResponse.setMessage("Successfully issues the books");
        messageResponse.setStatus(200);
        return messageResponse;
}

    public List<OrderDetails> getIssueBook(String regNo){
        List<OrderDetails> order=  orderDetailsRepository.findOrderByRegNo(regNo);
//        List<OrderDetails> ordered=new ArrayList<>();
//        for(OrderDetails orderDetails:order){
//           String bookId= orderDetails.getBookId();
//            Book book=new Book();
//            if(bookId.equals(book.getBookId())){
//                ordered.add(book.getBookName());
//                ordered.add(book.getAuthor());
//            }
//        }
        return order;
    }
}
