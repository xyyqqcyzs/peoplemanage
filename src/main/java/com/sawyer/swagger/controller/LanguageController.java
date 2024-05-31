package com.sawyer.swagger.controller;

import com.sawyer.entity.Language;
import com.sawyer.entity.Position;
import com.sawyer.service.LanguageService;
import com.sawyer.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Language> findbyemp(@RequestParam int emp_ID) {
        List<Language> allList = lanService.findbyemp(emp_ID);
        return allList;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Language lan) {
        lanService.add(lan);
        return ResponseEntity.ok("添加成功！");
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int language_ID) {
            lanService.delete(language_ID);
            return ResponseEntity.ok("删除成功！");
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> update(@RequestParam Language lan) {
        lanService.update(lan);
        return ResponseEntity.ok("更新成功！");
    }

}
