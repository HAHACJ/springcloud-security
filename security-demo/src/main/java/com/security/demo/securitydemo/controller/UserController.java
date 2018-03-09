package com.security.demo.securitydemo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.security.demo.securitydemo.entity.User;
import com.security.demo.securitydemo.entity.UserDetailView;
import com.security.demo.securitydemo.entity.UserSimpleView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(UserSimpleView.class)
    public List<User> query(@RequestParam(defaultValue = "123") String username) {
        System.out.println(username);
        List<User> list = new ArrayList<>();
        list.add(new User());
        list.add(new User());
        list.add(new User());
        return list;
    }

    @GetMapping("/{id}")
    @JsonView(UserDetailView.class)
    public User findById(@PathVariable String id) {
        return new User();
    }

    /**
     * 创建用户，使用@Valid和 @NotBlank注解进行非空校验
     * @param user
     * @return
     */
    @PostMapping("/create")
    public String create(@Valid @RequestBody User user, BindingResult error) {

        if (error.hasErrors()) {
            error.getAllErrors()
                .stream()
                .forEach(errors -> System.out.println(errors));
        }

        System.out.println(new Date().getTime());
        System.out.println(user);
        return "success!";
    }


    @PutMapping("/update/{id}")
    public String update(@Valid @RequestBody User user, BindingResult errors, @PathVariable String id) {

        System.out.println(id);
        if (errors.hasErrors()) {
            errors.getAllErrors()
                .stream()
                .forEach(error -> System.out.println(error));
        }

        System.out.println(new Date().getTime());
        System.out.println(user);
        return "success!";
    }
}
