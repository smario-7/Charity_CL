package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.UserWriteDto;
import pl.coderslab.charity.model.CharityUser;

public interface UserService {
    CharityUser findByEmail(String email);

    void save(UserWriteDto userWriteDto);

    boolean emailExist(UserWriteDto userWriteDto);

    boolean passwordConfirm(UserWriteDto userWriteDto);
}
