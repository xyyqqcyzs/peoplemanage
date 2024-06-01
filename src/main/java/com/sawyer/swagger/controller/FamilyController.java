package com.sawyer.swagger.controller;

import com.sawyer.entity.Family;
import com.sawyer.entity.Language;
import com.sawyer.service.FamilyService;
import com.sawyer.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Family> findbyemp(@RequestParam int emp_ID) {
        List<Family> allList = fanService.findbyemp(emp_ID);
        return allList;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Family fan) {
        fanService.add(fan);
        return ResponseEntity.ok("添加成功");
    }
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int relation_ID) {
            fanService.delete(relation_ID);
            return ResponseEntity.ok("删除成功");
    }

    @PutMapping(value = "update")
    public ResponseEntity<String> update(@RequestBody Family fan) {
        fanService.update(fan);
        return ResponseEntity.ok("更新成功");
    }

}
