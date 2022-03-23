package lms.service;

import lms.dto.request.UserInfoRequest;
import lms.dto.response.MessageResponse;
import lms.model.Book;
import lms.model.User;
import lms.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public User saveInfo(UserInfoRequest userInfoRequest){
       User user = new User();
       user.setEmailId(userInfoRequest.getEmailId());
       user.setPassword(userInfoRequest.getPassword());
       user.setRegNo(userInfoRequest.getRegNo());
       return userRepository.save(user);
    }

    public MessageResponse getInfo(UserInfoRequest userInfoRequest){
        User user1 = userRepository.findByRegNo(userInfoRequest.getRegNo());
        MessageResponse mess = new MessageResponse();
        if(user1 == null){
            mess.setMessage("Failed, Student Not Found");
            mess.setStatus(404);
            return mess;
        }
        if(userInfoRequest.getPassword().equals(user1.getPassword())){
            mess.setMessage("Success, User Logged in successfully");
            mess.setStatus(200);
        }
        else{
             mess.setMessage("Failed, Wrong registration no or password");
             mess.setStatus(503);
        }
        return mess;
    }

}
