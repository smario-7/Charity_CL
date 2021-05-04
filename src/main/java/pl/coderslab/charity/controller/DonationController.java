package pl.coderslab.charity.controller;

import antlr.actions.python.CodeLexer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.Collection;

@Controller
@RequestMapping("/formdonation")
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
    }

    @GetMapping
    public String formDonation(){
        return "formDonation";
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
