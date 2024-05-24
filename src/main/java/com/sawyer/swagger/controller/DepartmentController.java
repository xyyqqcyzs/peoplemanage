package com.sawyer.swagger.controller;

import com.sawyer.entity.Department;

import com.sawyer.service.DepService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepService depService;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<Department> findAll() {
        List<Department> allList = depService.findAll();
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
    public String add(Department dep) {
        depService.add(dep);
        return "添加成功！";
    }

    @GetMapping(value = "/delete")
    public String delete(int id) {
        try {
            depService.delete(id);
            return "删除成功！";
        } catch (Exception e) {
            if (HttpStatus.INTERNAL_SERVER_ERROR.value() == 500) {
                return "500错误：该部门无法删除";
            } else {
                return "发生错误：" + e.getMessage();
            }
        }
    }

    @GetMapping(value = "/find")
    public Department find(int id, Model model) {
        Department dep = depService.find(id);
        model.addAttribute("Department", dep);
        return dep;
    }

    @PostMapping(value = "update")
    public String update(Department dep) {
        depService.update(dep);
        return "更新成功！";
    }

}
