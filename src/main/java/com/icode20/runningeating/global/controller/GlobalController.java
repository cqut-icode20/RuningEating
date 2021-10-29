package com.icode20.runningeating.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *author
 *description
 @date 2021/10/29 20:35
 */
@Controller
public class GlobalController {
    @ResponseBody
    @GetMapping("/login")
    public String login() {
        return "this is login html";
    }
}
