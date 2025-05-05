package com.example.demo.app.the_remains_of_the_artificial_beach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/the_remains_of_the_artificial_beach")
public class ScapeController {
	
    // index
    @GetMapping()
    public String showSitemap() {
        return "the_remains_of_the_artificial_beach/index";  // templates/index.html を返す
    }

}
