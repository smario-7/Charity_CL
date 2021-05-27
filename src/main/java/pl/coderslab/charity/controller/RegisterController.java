package pl.coderslab.charity.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.dto.UserWriteDto;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private static final Logger log = LoggerFactory.getLogger(DonationController.class);
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String userRegister (Model model){
        model.addAttribute("user", new UserWriteDto());
        return "register";
    }
    @PostMapping
    public String postUserRegister (@ModelAttribute("user") @Valid UserWriteDto user, BindingResult bindingResult) {
        log.info("!!!!! {}" , user);

        if (bindingResult.hasErrors()){
            return "register";
        } else if (!userService.passwordConfirm(user)) {
            bindingResult.rejectValue("passwordRepeat", "passwordRepeat","różne hasła");
            if (userService.emailExist(user)){
                bindingResult.rejectValue("email","email", "email już istneje");
                return "register";
            }
            return "register";
        }
        userService.save(user);
        return "login";
    }
}
