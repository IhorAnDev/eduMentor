package com.enterprise.edumentorapi.validations;

import com.enterprise.edumentorapi.anotations.PasswordMatches;
import com.enterprise.edumentorapi.payload.request.auth.SignUpRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        SignUpRequest userSignUpRequest = (SignUpRequest) object;

        if (!userSignUpRequest.getPassword().equals(userSignUpRequest.getConfirmPassword())) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passwords do not match")
                    .addPropertyNode("confirmPassword")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}