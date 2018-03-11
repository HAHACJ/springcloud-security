package com.security.demo.securitydemo.entity;

import com.fasterxml.jackson.annotation.JsonView;
import com.security.demo.securitydemo.validcustome.MyValid;
import org.hibernate.validator.constraints.NotBlank;

public class User {

    private String id;

    @MyValid(message = "名字测试")
    private String name;

    @NotBlank(message = "密码不能为空")
    private String password;

    @JsonView(UserSimpleView.class)
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
