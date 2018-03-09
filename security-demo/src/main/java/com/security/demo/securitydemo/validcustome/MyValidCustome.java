package com.security.demo.securitydemo.validcustome;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidCustome implements ConstraintValidator<MyValid, String> {
    @Override
    public void initialize(MyValid myValid) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
