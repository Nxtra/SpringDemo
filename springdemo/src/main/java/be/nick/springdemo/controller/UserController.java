package be.nick.springdemo.controller;

import be.nick.springdemo.model.User;
import be.nick.springdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user")
    public String userForm(Model model, User user){
        model.addAttribute(user);
        return "user";
    }

    @PostMapping("/user")
    public String userSubmit(@Valid @ModelAttribute User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "user";
        }

        userRepository.save(user);
        return "userSuccess";
    }
}
