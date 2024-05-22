package com.sawyer.swagger.controller;

import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Employeemov;
import com.sawyer.entity.Position;
import com.sawyer.service.EmpService;
import com.sawyer.service.EmpmovService;
import com.sawyer.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/emmployeemov")
public class EmpmovController {
    @Autowired
    private EmpmovService movService;
    @Autowired
    private EmpService empService;

    private Employee emp;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<Employeemov> findAll() {
        List<Employeemov> allList = movService.findAll();
        return allList;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public String add(Employeemov mov) {
        int id = mov.getEmp_ID();
        int dep = mov.getAfter_dep();
        int pos = mov.getAfter_pos();
        this.emp = empService.findbyID(id);
        this.emp.get_after_dep_ID(dep);
        this.emp.get_after_pos_ID(pos);
        empService.update(this.emp);
        movService.add(mov);
        return "添加成功！";
    }

    @GetMapping(value = "/delete")
    public String delete(int mov_ID) {
            movService.delete(mov_ID);
            return "删除成功！";
    }

    @GetMapping(value = "/findbyemp")
    public List<Employeemov> findbyemp(int emp_ID) {
        List<Employeemov> allList = movService.findbyemp(emp_ID);
        return allList;
    }

}
