package com.springpoc.springpoc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageCtrl {
    @GetMapping
    public String home() {
        return "index";
    }
}
