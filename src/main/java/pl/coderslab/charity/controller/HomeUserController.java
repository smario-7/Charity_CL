package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class HomeUserController {

    @GetMapping
    public String homeUserAction(){
        return "homeUser";
    }

}
