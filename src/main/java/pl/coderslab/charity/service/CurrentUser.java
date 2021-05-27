package pl.coderslab.charity.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import pl.coderslab.charity.model.CharityUser;

import java.util.Collection;

public class CurrentUser extends User {
    private final CharityUser charityUser;

    public CurrentUser(String email, String password, Collection<? extends GrantedAuthority> authorities,
                       CharityUser charityUser) {
        super(email, password, authorities);
        this.charityUser = charityUser;
    }
    public CharityUser getUser(){return charityUser;}
}
