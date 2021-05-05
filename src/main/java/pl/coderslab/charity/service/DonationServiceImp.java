package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.DonationFormDto;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.persistence.EntityNotFoundException;

@Service
public class DonationServiceImp implements DonationService {
    private final DonationRepository donationRepository;
    private final CategoryRepository categoryRepository;
    private final InstitutionRepository institutionRepository;

    public DonationServiceImp(DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    public Integer sumAllByQuantity(){
        return donationRepository.sumAllByQuantity();
    }

    public Long countAllDonations(){
        return donationRepository.count();
    }

    public void add(DonationFormDto donationFormDto){
        Donation newDonation = new Donation();
        newDonation.setQuantity(donationFormDto.getQuantity());
        newDonation.setCategories(categoryRepository.findAllById(donationFormDto.getCategories()));
        newDonation.setInstitution(institutionRepository.findById(donationFormDto.getInstitution()).orElseThrow(EntityNotFoundException::new));
        newDonation.setStreet(donationFormDto.getStreet());
        newDonation.setCity(donationFormDto.getCity());
        newDonation.setZipCode(donationFormDto.getZipCode());
        newDonation.setPhoneNumber(donationFormDto.getPhoneNumber());
        newDonation.setPickUpDate(donationFormDto.getPickUpDate());
        newDonation.setPickUpTime(donationFormDto.getPickUpTime());
        newDonation.setPickUpComment(donationFormDto.getPickUpComment());

        donationRepository.save(newDonation);
    }
}
