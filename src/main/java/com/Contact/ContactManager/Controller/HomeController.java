package com.Contact.ContactManager.Controller;

import com.Contact.ContactManager.Entity.User;
import com.Contact.ContactManager.dao.UserRepo;
import com.Contact.ContactManager.helper.Message;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    @Autowired
    private UserRepo userRepo;

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

    @GetMapping("/about")
    public String About(){
        return "About";
    }
    @GetMapping("/signup")
    public String Signup(Model model ){
        model.addAttribute("title","Register Smart Contact Manager");
        model.addAttribute("user",new User());
        return "Signup";
    }

    @PostMapping("/do_register")
    public String registerUser(@ModelAttribute("user") User user , @RequestParam(value ="agreement" ,defaultValue = "false") boolean agreement, Model model, HttpSession session){

        try{
            if(!agreement){
                System.out.println("you have not agreed to terms and conditions");
                 throw new Exception("you have not agreed to terms and conditions");
            }
            user.setRole("ROLE_USER");
            user.setIsenabled(true);

            System.out.println("Agreement " +agreement );
            System.out.println("USER "+user);

            User result= this.userRepo.save(user);
            model.addAttribute("user",new User());

            session.setAttribute("message",new Message("Successfully Registered","alert-success"));
            return "signup";
        }
        catch (Exception e){
            e.printStackTrace();
            model.addAttribute("user",user);
            session.setAttribute("message" ,new Message("Something went wrong "+e.getMessage(),"alert-danger"));
            return "signup";
        }

    }
}
