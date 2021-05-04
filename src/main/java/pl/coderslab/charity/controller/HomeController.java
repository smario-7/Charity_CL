package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.Collection;


@Controller
public class HomeController {
    final private InstitutionService institutionService;
    final private DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @RequestMapping("/")
    public String homeAction(){
        return "index";
    }

    @ModelAttribute("institutions")
    public Collection<Institution> institutions(){
        return institutionService.findAll();
    }

    @ModelAttribute("allQuantity")
    public Integer sumOfQuantity() {
        return donationService.sumAllByQuantity();
    }
    @ModelAttribute("allDonations")
    public Long countAllDonations(){
        return donationService.countAllDonations();
    }


}
