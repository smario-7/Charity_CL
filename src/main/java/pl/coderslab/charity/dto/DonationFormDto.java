package pl.coderslab.charity.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Arrays;
import java.util.List;

public class DonationFormDto {

    @Digits(integer = 3, fraction = 0)
    @NotNull (message = "nie podałeś ile worków")
    private Integer quantity;
    @NotEmpty (message = "nie wybrałeś kategorii")
    private List<Long> categories;
    @NotNull (message = "nie wybrałeś instytucji")
    private Long institution;
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @Pattern(regexp = "([0-9]{2})-([0-9]{3})", message = "błędny format (XX-XXX)")
    private String zipCode;
    @Pattern(regexp = "([0-9]{9})", message = "błędny format (XXXXXXXXX)")
    private String phoneNumber;
    @Future (message = "zaznacz przyszłą datę")
    @NotNull (message = "wybierz datę")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    @NotNull (message = "podaj godzinę odbioriu")
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime pickUpTime;
    @Size(max = 255, message = "maksymalnie 255 znaków")
    private String pickUpComment;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Long> getCategories() {
        return categories;
    }

    public void setCategories(List<Long> categories) {
        this.categories = categories;
    }

    public Long getInstitution() {
        return institution;
    }

    public void setInstitution(Long institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }

    @Override
    public String toString() {
        return "DonationFormDto{" +
                "quantity=" + quantity +
                ", categories=" + categories +
                ", institution=" + institution +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pickUpDate=" + pickUpDate +
                ", pickUpTime=" + pickUpTime +
                ", pickUpComment='" + pickUpComment + '\'' +
                '}';
    }
}
