package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.DonationFormDto;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/formdonation")
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping
    public String formDonation(Model model) {
        model.addAttribute("donation", new DonationFormDto());
        return "formDonation";
    }

    @PostMapping
    public String postFormDonation(@ModelAttribute("donation") @Valid DonationFormDto donation, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "error";
        }
        donationService.add(donation);
        return "redirect:/form-confirmation";
    }

    @ModelAttribute("categories")
    public Collection<Category> allCategory(){
        return categoryService.findAll();
    }

    @ModelAttribute("institutions")
    public Collection<Institution> institutions(){
        return institutionService.findAll();
    }


}
