package org.project.mars.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {
    public static final String ATTRIBUTE_ERROR = "error";
    public static final String PATH_ERROR_TEMPLATE = "error/error-page";

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public String handleBusinessException(RuntimeException runtimeException, Model model) {
        model.addAttribute(ATTRIBUTE_ERROR, "Something went wrong!");
        return PATH_ERROR_TEMPLATE;
    }
}
