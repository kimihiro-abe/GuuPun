package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // ルートURL（/）にアクセスしたときにサイトマップを表示
    @GetMapping({"/", "/index"})
    public String showSitemap() {
        return "index";  // templates/index.html を返す
    }
}