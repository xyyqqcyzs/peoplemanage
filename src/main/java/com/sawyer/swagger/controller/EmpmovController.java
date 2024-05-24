package com.sawyer.swagger.controller;

import com.sawyer.entity.*;
import com.sawyer.service.EmpService;
import com.sawyer.service.EmpmovService;
import com.sawyer.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/employeemov")
public class EmpmovController {
    @Autowired
    private EmpmovService movService;
    @Autowired
    private EmpService empService;
    private Employee emp;

    @GetMapping(value = "/findAll")
    public List<Employeemov> findAll() {
        List<Employeemov> allList = movService.findAll();
        return allList;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Employeemov mov) {
        int id = mov.getEmp_ID();
        int dep = mov.getAfter_dep();
        int pos = mov.getAfter_pos();
        this.emp = empService.findbyID(id);
        this.emp.get_after_dep_ID(dep);
        this.emp.get_after_pos_ID(pos);
        empService.update(this.emp);
        movService.add(mov);
        return ResponseEntity.ok("添加成功！");
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int mov_ID) {
            movService.delete(mov_ID);
            return ResponseEntity.ok("删除成功！");
    }

    @GetMapping(value = "/findbyemp")
    public List<Employeemov> findbyemp(@RequestParam int emp_ID) {
        List<Employeemov> allList = movService.findbyemp(emp_ID);
        return allList;
    }
    @GetMapping(value = "/findbytype")
    public List<Employeemov> findbytype(@RequestParam String movtype) {
        List<Employeemov> allList = movService.findbytype(movtype);
        return allList;
    }

    @PostMapping(value = "/findbytime")
    public List<Employeemov> findbytime(@RequestBody Movtime movtime) {
        Date datea = movtime.getDatea();
        Date dateb = movtime.getDateb();
        List<Employeemov> allList = movService.findbytime(datea,dateb);
        return allList;
    }

}
