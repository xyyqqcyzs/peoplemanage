package com.sawyer.swagger.controller;

import com.sawyer.entity.Family;
import com.sawyer.entity.Language;
import com.sawyer.service.FamilyService;
import com.sawyer.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/family")
public class FamilyController {

    @Autowired
    private FamilyService fanService;

    @GetMapping(value = "/findbyemp")
    @ResponseBody
    public List<Family> findbyemp(int emp_ID) {
        List<Family> allList = fanService.findbyemp(emp_ID);
        return allList;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public String add(Family fan) {
        fanService.add(fan);
        return "添加成功！";
    }

    @GetMapping(value = "/delete")
    public String delete(int relation_ID) {
            fanService.delete(relation_ID);
            return "删除成功！";
    }

    @PostMapping(value = "update")
    public String update(Family fan) {
        fanService.update(fan);
        return "更新成功！";
    }

}
