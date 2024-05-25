package com.sawyer.swagger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ValueExp;


@Controller
public class IndexController {
    @GetMapping(value = "/index")
    public String toIndex() {
        return "/login";
    }

    @GetMapping(value = "toSave")
    public String toSave() {
        return "ems/addEmp";
    }

}
