package pl.coderslab.charity.controller.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.CharityUser;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.InstitutionService;

import java.util.Collection;

@Controller
@RequestMapping("/admin/institution")
public class InstitutionAdminContoller {
    final private InstitutionService institutionService;

    public InstitutionAdminContoller(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String institutionView(){
        return "admin/institutionAdmin";
    }

    @ModelAttribute("emailUser")
    public String emailUser(@AuthenticationPrincipal CurrentUser currentUser){
        return currentUser.getUsername();
    }

    @ModelAttribute("institutions")
    public Collection<Institution> institutions(){
        return institutionService.findNFirst(10);
    }

}
