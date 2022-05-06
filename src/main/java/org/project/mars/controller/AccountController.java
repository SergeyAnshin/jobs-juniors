package org.project.mars.controller;

import org.project.mars.dto.RegisteringEmployer;
import org.project.mars.dto.RegisteringUser;
import org.project.mars.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.project.mars.controller.ExceptionHandlerController.ATTRIBUTE_ERROR;

@Controller
@RequestMapping("/account")
public class AccountController {
    public static final String ATTRIBUTE_USER = "user";
    public static final String ATTRIBUTE_EMPLOYER = "employer";
    public static final String PATH_USER_SIGNUP_TEMPLATE = "account/user-signup";
    public static final String PATH_EMPLOYER_SIGNUP_TEMPLATE = "account/employer-signup";
    public static final String PATH_LOGIN_TEMPLATE = "account/login";
    public static final String REDIRECT_TO_LOGIN_PAGE = "redirect:/account/login";
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/signup/user")
    public String getUserSignupTemplate(@ModelAttribute(ATTRIBUTE_USER) RegisteringUser registeringUser) {
        return PATH_USER_SIGNUP_TEMPLATE;
    }

    @PostMapping("/signup/user")
    public String signupUser(@ModelAttribute(ATTRIBUTE_USER) @Valid RegisteringUser registeringUser,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_USER_SIGNUP_TEMPLATE;
        } else {
            boolean isRegistered = accountService.signupUser(registeringUser);
            if (isRegistered) {
                return REDIRECT_TO_LOGIN_PAGE;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_USER_SIGNUP_TEMPLATE;
            }
        }
    }

    @GetMapping("/signup/employer")
    public String getEmployerSignupTemplate(@ModelAttribute(ATTRIBUTE_EMPLOYER) RegisteringEmployer registeringEmployer) {
        return PATH_EMPLOYER_SIGNUP_TEMPLATE;
    }

    @PostMapping("/signup/employer")
    public String signupEmployer(@ModelAttribute(ATTRIBUTE_EMPLOYER) @Valid RegisteringEmployer registeringEmployer,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return PATH_EMPLOYER_SIGNUP_TEMPLATE;
        } else {
            boolean isRegistered = accountService.signupEmployer(registeringEmployer);
            if (isRegistered) {
                return REDIRECT_TO_LOGIN_PAGE;
            } else {
                model.addAttribute(ATTRIBUTE_ERROR, "Already exists!");
                return PATH_EMPLOYER_SIGNUP_TEMPLATE;
            }
        }
    }

    @GetMapping("/login")
    public String getLoginTemplate(@RequestParam(required = false) boolean failed, Model model) {
        if (failed) {
            model.addAttribute(ATTRIBUTE_ERROR, "User doesn't exist!");
        }
        return PATH_LOGIN_TEMPLATE;
    }
}
