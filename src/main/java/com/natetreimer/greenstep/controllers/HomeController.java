package com.natetreimer.greenstep.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
public class HomeController {

    @RequestMapping(value="/")
    public String getHomePage() {
        return "index";
    }

}
