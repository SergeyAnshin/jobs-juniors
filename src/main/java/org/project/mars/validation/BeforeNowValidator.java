package org.project.mars.validation;

import org.project.mars.validation.constraints.BeforeNow;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BeforeNowValidator implements ConstraintValidator<BeforeNow, LocalDate> {

    @Override
    public void initialize(BeforeNow constraintAnnotation) {

    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        } else {
            return value.isBefore(LocalDate.now()) || value.isEqual(LocalDate.now());
        }
    }
}
