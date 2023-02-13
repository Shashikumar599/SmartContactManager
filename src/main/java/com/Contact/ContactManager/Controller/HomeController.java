package com.Contact.ContactManager.Controller;

import com.Contact.ContactManager.Entity.User;
import com.Contact.ContactManager.dao.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    UserRepo userRepo;

//    @GetMapping("/Home")
//    @ResponseBody
//    public String Home(){
//        User user=new User();
//        user.setId(123);
//        user.setName("Shashi");
//        userRepo.save(user);
//        return "Welcome to Smart Manager";
//
//    }
    @GetMapping("/home")
    public String Home(){
     return "Home";
    }
}
