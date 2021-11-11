package com.mvctask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AccessDeniedController {

    @ResponseBody
    @GetMapping("/access/denied")
    public String accessDenied() {
        return "YOU CANNOT BE HERE!";
    }
}