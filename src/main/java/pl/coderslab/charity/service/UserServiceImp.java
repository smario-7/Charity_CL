package pl.coderslab.charity.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.UserWriteDto;
import pl.coderslab.charity.model.CharityUser;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public CharityUser findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(UserWriteDto userWriteDto) {
        CharityUser charityUser = new CharityUser();
        charityUser.setEmail(userWriteDto.getEmail());
        charityUser.setPassword(passwordEncoder.encode(userWriteDto.getPassword()));
        charityUser.enable();
        Role roles = roleRepository.findByName("ROLE_USER");
        charityUser.addRole(roles);
        userRepository.save(charityUser);
    }

    public boolean emailExist(UserWriteDto userWriteDto){
        return userRepository.existsByEmail(userWriteDto.getEmail());
    }

    public boolean passwordConfirm(UserWriteDto userWriteDto){
        return userWriteDto.getPassword().equals(userWriteDto.getPasswordRepeat());
    }
}
// set enabled jako gotową metodę w user, ustawiajacą parametr na 1
// metoda sprawdzająca czy użytkownik istnieje
// metaoda do porównania haseł