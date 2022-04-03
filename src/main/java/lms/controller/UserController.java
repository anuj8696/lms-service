package lms.controller;

import lms.dto.request.UserInfoRequest;
import lms.model.Book;
import lms.model.User;
import lms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "https://nit-jsr-lms-service.herokuapp.com")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value ="/signUpUser")
    public ResponseEntity<?> signUpUser(@RequestBody UserInfoRequest userInfoRequest){
       User obj= userService.saveInfo(userInfoRequest);
       return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value="/resultLoggin")
    public ResponseEntity<?> resultLoggin(@RequestParam String regNo, @RequestParam String password) {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.setRegNo(regNo);
        userInfoRequest.setPassword(password);
        return new ResponseEntity<>(userService.getInfo(userInfoRequest),HttpStatus.OK);
    }
}
