package com.sawyer.swagger.controller;


import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import com.sawyer.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Employee> findAll() {
        List<Employee> allList = empService.findAll();
        return allList;
    }

    //根据岗位ID查询
    @GetMapping(value = "/findbypos")
    public List<Employee> findbypos(@RequestParam int pos_ID) {
        List<Employee> allList = empService.findbypos(pos_ID);
        return allList;
    }

    //根据部门ID查询
    @GetMapping(value = "/findbydep")
    public List<Employee> findbydep(@RequestParam int dep_ID) {
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
    public List<Employee> findbyMode(@RequestParam String mode){
        List<Employee> allList = empService.findbyMode(mode);
        return allList;
    }

    //查询所有实习生
    @GetMapping(value = "findbyemptype")
    public List<Employee> findbyemptype(@RequestParam String emp_type){
        List<Employee> allList = empService.findbyemptype(emp_type);
        return allList;
    }
    /*@PostMapping(value = "findbyemptype")
    public ResponseEntity<List<Employee>> findbyemptype(@RequestParam String emp_type){
        List<Employee> allList = empService.findbyemptype(emp_type);
        return ResponseEntity.ok(allList);
    }*/



    //添加员工
    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Employee emp) {
        empService.add(emp);
        return ResponseEntity.ok("添加成功");
    }

    //删除员工
    @GetMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int id) {
        empService.delete(id);
        return ResponseEntity.ok("删除成功");
    }

    //根据员工ID查询
    @GetMapping(value = "/findbyID")
    public Employee findbyID(@RequestParam int id) {
        Employee emp = empService.findbyID(id);
        return emp;
    }

    @GetMapping(value="findcareer")
    public Career findcareer(@RequestParam int id){
        Career career = empService.findcareer(id);
        return career;
    }



    //员工信息更新
    /*@PostMapping(value = "update")
    public String update(@ResponseBody Employee emp) {
        empService.update(emp);
        return "更新成功";
    }*/
    @PostMapping(value = "update")
    public ResponseEntity<String> update(@RequestBody Employee emp) {
        empService.update(emp);
        return ResponseEntity.ok("更新成功");
    }
}
