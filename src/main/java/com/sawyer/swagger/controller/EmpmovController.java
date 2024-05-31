package com.sawyer.swagger.controller;

import com.sawyer.entity.*;
import com.sawyer.entity.Process;
import com.sawyer.service.EmpService;
import com.sawyer.service.EmpmovService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
        movService.add(mov);
        return ResponseEntity.ok("添加成功！");
    }
    @PutMapping(value = "/update")//更新值不能为空
    public ResponseEntity<String> update(@RequestBody Employeemov mov) {
        movService.update(mov);
        return ResponseEntity.ok("更新成功");
    }

    @GetMapping(value = "/findbyID")
    public Employeemov findbyID(@RequestParam int id) {
        Employeemov mov = movService.findbyID(id);
        return mov;
    }

    @PostMapping(value = "/process")
    public ResponseEntity<String> process(@RequestBody Process process) {
        int idd = process.getId();
        Date date = process.getDate();
        Employeemov mov = movService.findbyID(idd);
        int id = mov.getEmp_ID();
        int dep = mov.getAfter_dep();
        int pos = mov.getAfter_pos();
        this.emp = empService.findbyID(id);
        this.emp.get_after_dep_ID(dep);
        this.emp.get_after_pos_ID(pos);
        empService.update(this.emp);
        mov.setProcess_state("已处理");
        mov.setMov_date(date);
        movService.update(mov);
        return ResponseEntity.ok("已处理");
    }

    @PostMapping(value="/reject")
    public ResponseEntity<String> reject(@RequestBody Process process) {
        int idd = process.getId();
        Date date = process.getDate();
        Employeemov mov = movService.findbyID(idd);
        mov.setProcess_state("已拒绝");
        mov.setMov_date(date);
        movService.update(mov);
        return ResponseEntity.ok("已处理");
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int mov_ID) {
        movService.delete(mov_ID);
        return ResponseEntity.ok("删除成功！");
    }

/*
    @GetMapping(value = "/findbyemp")
    public List<Employeemov> findbyemp(@RequestParam int emp_ID) {
        List<Employeemov> allList = movService.findbyemp(emp_ID);
        return allList;
    }
    @GetMapping(value = "/findbytype")
    public List<Employeemov> findbytype(@RequestParam String movtype) {
        List<Employeemov> allList = movService.findbytype(movtype);
        return allList;
    }*/


    @PostMapping(value = "/findby")
    public List<Employeemov> findby(@RequestBody Movtime movtime) {
        Integer emp_ID = movtime.getEmp_ID();
        Date datea = movtime.getDatea();
        Date dateb = movtime.getDateb();
        String movtype = movtime.getMovtype();
        String process_state = movtime.getProcess_state();
        if ("".equals(movtype)) {
            movtype = null;
        }
        List<Employeemov> allList = movService.findby(emp_ID, datea, dateb, movtype,process_state);
        return allList;
    }
}
