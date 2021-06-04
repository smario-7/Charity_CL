package pl.coderslab.charity.controller.admin;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.InstitutionReadDto;
import pl.coderslab.charity.dto.InstitutionWriteDto;
import pl.coderslab.charity.service.CurrentUser;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/admin/institution")
public class InstitutionAdminContoller {
    final private InstitutionService institutionService;

    public InstitutionAdminContoller(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping
    public String newInstitution(Model model){
        model.addAttribute("newInstitution", new InstitutionWriteDto());
        return "admin/institutionAdmin";
    }
    @PostMapping
    public String postNewInstitution(@Valid InstitutionWriteDto newInstitution, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "error";
        }
        institutionService.save(newInstitution);
        return "redirect:/admin/institution";
    }
    @GetMapping("/delete/{id}")
    public String deleteInstitution (@PathVariable Long id){
        institutionService.delete(id);
        return "redirect:/admin/institution";
    }
    @GetMapping("/edit/{id}")
    public String editInstitution (@PathVariable Long id, Model model){
        InstitutionReadDto institutionReadDto = institutionService.findById(id);
        model.addAttribute("editInstitution", institutionReadDto);
        return "admin/institutionEditAdmin";
    }
    @PostMapping("/edit/{id}")
    public String postEditInstitution(@ModelAttribute("editInstitution") @Valid InstitutionReadDto institutionReadDto
            ,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "error";
        }
        institutionService.update(institutionReadDto);
        return "redirect:/admin/institution";
    }

    @ModelAttribute("emailUser")
    public String emailUser(@AuthenticationPrincipal CurrentUser currentUser){
        return currentUser.getUsername();
    }

    @ModelAttribute("institutions")
    public Collection<InstitutionReadDto> institutions(){
        return institutionService.findNFirst(20);
    }

}
