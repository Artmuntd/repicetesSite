package com.example.repicesite.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@Tag(name = "Проверочный контроллер")
public class InfoController {
    @GetMapping
    public String hello(){
        return "Application is started!";
    }
}
