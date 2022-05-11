package org.project.mars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/")
public class HomeController {
    public static final String PATH_HOME_TEMPLATE = "homepage/home";
    public static final String PATH_EMPLOYER_HOME_TEMPLATE = "homepage/employer-home";

    @GetMapping
    public String getHomeTemplate() {
        return PATH_HOME_TEMPLATE;
    }

    @GetMapping("/employer")
    public String getEmployerHomeTemplate() {
        return PATH_EMPLOYER_HOME_TEMPLATE;
    }
}
