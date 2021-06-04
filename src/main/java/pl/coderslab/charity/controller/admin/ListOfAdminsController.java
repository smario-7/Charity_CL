package pl.coderslab.charity.controller.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.service.CurrentUser;

@Controller
@RequestMapping("/admin/listofadmins")
public class ListOfAdminsController {

    @GetMapping
    public String listOfAdmins(){
        return "admin/listOfAdmins";
    }

    @ModelAttribute("emailUser")
    public String emailUser(@AuthenticationPrincipal CurrentUser currentUser){
        return currentUser.getUsername();
    }

}
