package com.sawyer.swagger.controller;

import com.sawyer.entity.Language;
import com.sawyer.entity.Position;
import com.sawyer.service.LanguageService;
import com.sawyer.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/language")
public class LanguageController {

    @Autowired
    private LanguageService lanService;

    @GetMapping(value = "/findbyemp")
    @ResponseBody
    public List<Language> findbyemp(int emp_ID) {
        List<Language> allList = lanService.findbyemp(emp_ID);
        return allList;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public String add(Language lan) {
        lanService.add(lan);
        return "添加成功！";
    }

    @GetMapping(value = "/delete")
    public String delete(int language_ID) {
            lanService.delete(language_ID);
            return "删除成功！";
    }

    @PostMapping(value = "update")
    public String update(Language lan) {
        lanService.update(lan);
        return "更新成功！";
    }

}
