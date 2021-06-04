package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.DonationFormDto;

public interface DonationService {
    Integer sumAllByQuantity();
    Long countAllDonations();
    void add(DonationFormDto donationFormDto);
}
