package com.ecommerce.ejadaproject.walletservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.ejadaproject.walletservice.models.User;
import com.ecommerce.ejadaproject.walletservice.repository.UserRepository;
@RequestMapping("/wallet-service/users")
@RestController
public class UserController {
 
    @Autowired
    private UserRepository userRepo;
     
    @GetMapping("/")
    public ModelAndView viewHomePage() {
        //return "index";
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    
    @GetMapping("/register")
    public  ModelAndView showRegistrationForm(Model model) {
        ModelAndView modelAndView = new ModelAndView("signup_form");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    
    @PostMapping("/process_register")
    public ModelAndView processRegister(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        userRepo.save(user);
        ModelAndView modelAndView = new ModelAndView("register_success");
        return modelAndView;
       
    }
    

}
