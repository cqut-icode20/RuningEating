package com.icode20.runningeating.global.controller;

import com.icode20.runningeating.global.service.GlobalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author LIXIN
 * @description
 * @date 2021/10/29 20:35
 */
@RestController
public class GlobalController {
    @Autowired
    GlobalService globalService;

    @GetMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password) {
        return globalService.login(userName, password);
    }

    @GetMapping("/register")
    public String registerUser(@RequestParam String userName, @RequestParam String password, @RequestParam String cheekCode, @RequestParam String emil, HttpServletRequest request) {
        return globalService.register(userName, password, emil, cheekCode, request);
    }

    @GetMapping("/sendMail")
    public String sendMail(@RequestParam String email, HttpServletResponse response) {
        return globalService.sendEmail(email, response);
    }
}

