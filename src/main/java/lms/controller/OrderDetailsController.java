package lms.controller;

import lms.dto.request.OrderDetailsRequest;
import lms.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

    @PostMapping(value="/issueBoook")
    public ResponseEntity<?> issueBoook(@RequestBody OrderDetailsRequest orderDetailsRequest){
       return new ResponseEntity<>(orderDetailsService.issueBoook(orderDetailsRequest), HttpStatus.OK);
    }

    @GetMapping(value="/getIssueBook/{regNo}")
    public ResponseEntity<?> getIssueBook(@PathVariable String regNo){
       return new ResponseEntity<> (orderDetailsService.getIssueBook(regNo),HttpStatus.OK);
    }

    @PostMapping(value="/returnBooks")
    public ResponseEntity<?> returnBooks(@RequestBody OrderDetailsRequest orderDetailsRequest){
        return new ResponseEntity<> (orderDetailsService.returnBooks(orderDetailsRequest),HttpStatus.OK);
    }
}
