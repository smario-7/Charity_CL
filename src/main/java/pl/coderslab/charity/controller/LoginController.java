package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

//    @GetMapping("logout")
//    public String getLogout(){
//        return "logout";
//    }
//    @PostMapping("logout")
//    public String logout(){
//        return "logout";
//    }
}
