package pl.coderslab.charity.dto;

import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.*;

public class UserWriteDto {

    @Email (message = "błędny format")
    @NotBlank (message = "puste pole")
    private String email;
    @Size(min = 6, message = "min 6 znaków")
    @NotBlank (message = "puste pole")
    private String password;
    @NotBlank

    private String passwordRepeat;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }

    @Override
    public String toString() {
        return "UserWriteDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordRepeat='" + passwordRepeat + '\'' +
                '}';
    }
}

