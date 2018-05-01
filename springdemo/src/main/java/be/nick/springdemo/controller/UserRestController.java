package be.nick.springdemo.controller;

import be.nick.springdemo.model.User;
import be.nick.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public List<User> listUsers(){
        return userRepository.findAll();
    }
}
