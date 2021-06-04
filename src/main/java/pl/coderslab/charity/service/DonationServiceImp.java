package pl.coderslab.charity.service;

import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.repository.DonationRepository;

@Service
public class DonationServiceImp implements DonationService {
    private final DonationRepository donationRepository;

    public DonationServiceImp(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public Integer sumAllByQuantity(){
        return donationRepository.sumAllByQuantity();
    }

    public Long countAllDonations(){
        return donationRepository.count();
    }
}
