package com.example.geungeunhanjan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

    public String mainContentsByViews(){

        return "myLife/detail-others";
    }
}