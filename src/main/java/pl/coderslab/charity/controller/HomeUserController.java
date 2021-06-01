package pl.coderslab.charity.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.model.CharityUser;

@Controller
@RequestMapping("/user")
public class HomeUserController {

    @GetMapping
    public String homeUserAction(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        CharityUser charityUser = currentUser.getUser();
        model.addAttribute("emailUser", charityUser.getEmail());
        return "homeUser";
    }


}
