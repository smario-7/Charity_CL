package pl.coderslab.charity.service;

import pl.coderslab.charity.dto.UserWriteDto;
import pl.coderslab.charity.model.MatchingUser;

public interface UserService {
    MatchingUser findByEmail(String email);

    void save(UserWriteDto userWriteDto);

    boolean emailExist(UserWriteDto userWriteDto);

    boolean passwordConfirm(UserWriteDto userWriteDto);
}
