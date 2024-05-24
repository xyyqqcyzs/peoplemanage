package com.sawyer.swagger.controller;


import com.sawyer.entity.Employee;
import com.sawyer.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/employee")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<Employee> findAll() {
        List<Employee> allList = empService.findAll();
        return allList;
    }

    @GetMapping(value = "/findbypos")
    @ResponseBody
    public List<Employee> findbypos(int pos_ID) {
        List<Employee> allList = empService.findbypos(pos_ID);
        return allList;
    }

    @GetMapping(value = "/findbydep")
    @ResponseBody
    public List<Employee> findbydep(int dep_ID) {
        List<Employee> allList = empService.findbydep(dep_ID);
        return allList;
    }
    //find和findAll不是重定向，直接到跳转页面，并且直接跳转classpath下template自带/
    //重定向的话不是从template下，是需要加/的
    //查找不是重定向，不加/；重定向需要加/
    /*public String findAll(Model model) {
        List<Emp> allList = empService.findAll();
        model.addAttribute("emps", allList);
        return "ems/emplist";
    }*/


    @PostMapping(value = "/add")
    @ResponseBody
    public String add(Employee emp) {
        empService.add(emp);
        return "添加成功";
    }

    @GetMapping(value = "/delete")
    public String delete(int id) {
        empService.delete(id);
        return "删除成功";
    }

    @GetMapping(value = "/findbyID")
    public Employee findbyID(int id, Model model) {
        Employee emp = empService.findbyID(id);
        model.addAttribute("Employee", emp);
        return emp;
    }

    @PostMapping(value = "update")
    public String update(Employee emp) {
        empService.update(emp);
        return "更新成功";
    }
}
