package org.project.mars.validation;

import org.project.mars.validation.constraints.AfterNow;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class AfterNowValidator implements ConstraintValidator<AfterNow, LocalDate> {

    @Override
    public void initialize(AfterNow constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        } else {
            return value.isAfter(LocalDate.now()) || value.isEqual(LocalDate.now());
        }
    }
}
