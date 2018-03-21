package id.wiryawan.restapionetoone.controller;

import id.wiryawan.restapionetoone.exception.ResourceNotFoundException;
import id.wiryawan.restapionetoone.model.UserProfile;
import id.wiryawan.restapionetoone.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserProfileController {

    @Autowired
    UserProfileRepository userProfileRepository;

    //Get all user
    @GetMapping("/usersprofile")
    public List<UserProfile> gettAllUsers() {
        return userProfileRepository.findAll();
    }

}
