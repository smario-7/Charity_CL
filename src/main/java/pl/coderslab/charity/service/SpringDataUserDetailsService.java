package pl.coderslab.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.MatchingUser;

import javax.persistence.EntityExistsException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    private UserService userService;

    // przez konstruktor
    @Autowired
    public void setUserRepository(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        // optional orelsethrow
//        MatchingUser matchingUser = userService.findByEmail(email);
//        if(matchingUser == null){throw new UsernameNotFoundException(email);}

        MatchingUser matchingUser = Optional.ofNullable(userService.findByEmail(email)).orElseThrow(EntityExistsException::new);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        matchingUser.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
        return new User(matchingUser.getEmail(), matchingUser.getPassword(), grantedAuthorities);
    }
}
