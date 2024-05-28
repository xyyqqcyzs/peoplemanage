package com.sawyer.swagger.controller;

import com.sawyer.entity.Department;

import com.sawyer.entity.ResponseMessage;
import com.sawyer.service.DepService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping(value = "/department")

public class DepartmentController {

    @Autowired
    private DepService depService;

    @GetMapping(value = "/findAll")
    public List<Department> findAll() {
        List<Department> allList = depService.findAll();
        return allList;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String>  add(@RequestBody Department dep) {
        depService.add(dep);
        return ResponseEntity.ok("添加成功");
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int id) {
        try {
            depService.delete(id);
            return ResponseEntity.ok("删除成功");
        } catch (Exception e) {
            if (HttpStatus.INTERNAL_SERVER_ERROR.value() == 500) {
                return ResponseEntity.status(500).body("500错误：该部门无法删除");
            } else {
                return ResponseEntity.status(500).body("发生错误：" + e.getMessage());
            }
        }
    }

    @GetMapping(value = "/find")
    public Department find(@RequestParam int id) {
        Department dep = depService.find(id);
        return dep;
    }

    @PostMapping(value = "update")
    public ResponseEntity<String> update(@RequestBody Department dep) {
        depService.update(dep);
        return ResponseEntity.ok( "更新成功");
    }

}
