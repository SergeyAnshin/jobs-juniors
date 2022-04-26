package org.project.mars.controller;

import org.project.mars.dto.RegisteringUser;
import org.project.mars.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.project.mars.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;

@Controller
@RequestMapping("/user")
public class UserController {
    public static final String ATTRIBUTE_USER = "user";
    public static final String PATH_SIGNUP_TEMPLATE = "user/signup";
    public static final String REDIRECT_TO_LOGIN_PAGE = "redirect:/user/login";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signup")
    public String getSignupTemplate(@ModelAttribute(ATTRIBUTE_USER) RegisteringUser registeringUser) {
        return PATH_SIGNUP_TEMPLATE;
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute(ATTRIBUTE_USER) RegisteringUser registeringUser, Model model) {
        boolean isRegistered = userService.signup(registeringUser);
        if (isRegistered) {
            return REDIRECT_TO_LOGIN_PAGE;
        } else {
            model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
            return PATH_SIGNUP_TEMPLATE;
        }
    }
}
