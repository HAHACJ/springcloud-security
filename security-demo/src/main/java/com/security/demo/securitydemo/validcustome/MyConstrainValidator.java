package com.security.demo.securitydemo.validcustome;

import com.security.demo.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstrainValidator implements ConstraintValidator<MyValid, Object> {

    @Autowired
    UserService userService;


    @Override
    public void initialize(MyValid myValid) {

        System.out.println("MyValid init!");
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {

        userService.getUserName("tom");

        System.out.println("isValid:" + obj);

        return true;
    }
}
