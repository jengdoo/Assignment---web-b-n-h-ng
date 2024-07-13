package com.fpoly.assignmentjava6.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class UserController {
    public String home(){
        return "user/index";
    }
    @GetMapping("/shop-details")
    public String detail(){
        return "user/shop-details";
    }
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }
    @GetMapping("/register")
    public String register(){
        return "user/register";
    }
    @GetMapping("/logon")
    public String logon(){
        return "admin/logon";
    }
}
