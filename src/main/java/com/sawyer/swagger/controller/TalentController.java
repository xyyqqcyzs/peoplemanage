package com.sawyer.swagger.controller;


import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Findemp;
import com.sawyer.entity.Talentpool;
import com.sawyer.service.EmpService;
import com.sawyer.service.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/talentpool")
public class TalentController {

    @Autowired
    private TalentService talService;

    //查询所有员工
    @GetMapping(value = "/findAll")
    public List<Talentpool> findAll() {
        List<Talentpool> allList = talService.findAll();
        return allList;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Talentpool tal) {
        talService.add(tal);
        return ResponseEntity.ok("添加成功");
    }

    //删除员工
    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int id) {
        talService.delete(id);
        return ResponseEntity.ok("删除成功");
    }
    @GetMapping(value = "/findbyID")
    public Talentpool findbyID(@RequestParam int id) {
        Talentpool tal = talService.findbyID(id);
        return tal;
    }

}
