package com.sawyer.swagger.controller;


import com.sawyer.entity.Career;
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

    //查询所有员工
    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<Employee> findAll() {
        List<Employee> allList = empService.findAll();
        return allList;
    }

    //根据岗位ID查询
    @GetMapping(value = "/findbypos")
    @ResponseBody
    public List<Employee> findbypos(int pos_ID) {
        List<Employee> allList = empService.findbypos(pos_ID);
        return allList;
    }

    //根据部门ID查询
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

    //根据员工入职方式查询
    @GetMapping(value = "findbyMode")
    public List<Employee> findbyMode(String mode){
        List<Employee> allList = empService.findbyMode(mode);
        return allList;
    }

    //查询所有实习生
    @GetMapping(value = "findbyemptype")
    public List<Employee> findbyemptype(String emp_type){
        List<Employee> allList = empService.findbyemptype(emp_type);
        return allList;
    }


    //添加员工
    @PostMapping(value = "/add")
    @ResponseBody
    public String add(Employee emp) {
        empService.add(emp);
        return "添加成功";
    }

    //删除员工
    @GetMapping(value = "/delete")
    public String delete(int id) {
        empService.delete(id);
        return "删除成功";
    }

    //根据员工ID查询
    @GetMapping(value = "/findbyID")
    public Employee findbyID(int id, Model model) {
        Employee emp = empService.findbyID(id);
        model.addAttribute("Employee", emp);
        return emp;
    }

    @GetMapping(value="findcareer")
    public Career findcareer(int id){
        Career career = empService.findcareer(id);
        return career;
    }



    //员工信息更新
    @PostMapping(value = "update")
    public String update(Employee emp) {
        empService.update(emp);
        return "更新成功";
    }
}
