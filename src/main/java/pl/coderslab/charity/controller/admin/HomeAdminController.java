package pl.coderslab.charity.controller.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.CharityUser;
import pl.coderslab.charity.service.CurrentUser;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {

    @GetMapping
    public String homeAdminAction(@AuthenticationPrincipal CurrentUser currentUser, Model model){
        CharityUser charityUser = currentUser.getUser();
        model.addAttribute("emailUser", charityUser.getEmail());
        return "admin/homeAdmin";
    }
}
