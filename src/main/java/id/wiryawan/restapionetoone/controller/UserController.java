package id.wiryawan.restapionetoone.controller;

import id.wiryawan.restapionetoone.exception.ResourceNotFoundException;
import id.wiryawan.restapionetoone.model.User;
import id.wiryawan.restapionetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    //Get all user
    @GetMapping("/users")
    public List<User> gettAllUsers() {
        return userRepository.findAll();
    }

    //Get a user
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    //Create user
    @PostMapping("/users")
    public User createUsers(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    //Update user
    @PostMapping("/users/{id}")
    public User updateUsers(@PathVariable(value = "id") Integer id,
                           @Valid @RequestBody User detail) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User","id", id));
        user.setFirstName(detail.getFirstName());
        user.setLastName(detail.getLastName());
        user.setEmail(detail.getEmail());
        user.setPassword(detail.getPassword());

        User updatedUser = userRepository.save(user);
        return updatedUser;
    }

    // Delete user
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable(value = "id") Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.delete(user);

        return ResponseEntity.ok().build();
    }
}
