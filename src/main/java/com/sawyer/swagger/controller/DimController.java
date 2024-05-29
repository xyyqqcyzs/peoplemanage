package com.sawyer.swagger.controller;

import com.sawyer.entity.Dimission;
import com.sawyer.service.EmpService;
import com.sawyer.entity.ResponseMessage;
import com.sawyer.service.DimService;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

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
@RequestMapping(value = "/dimission")

public class DimController {

    @Autowired
    private DimService dimService;

    @GetMapping(value = "/findAll")
    public List<Dimission> findAll() {
        List<Dimission> allList = dimService.findAll();
        System.out.println(allList);
        return allList;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Dimission dim) {
        dimService.add(dim);
        return ResponseEntity.ok("添加成功");
    }

    @GetMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int id) {
        try {
            dimService.delete(id);
            return ResponseEntity.ok("删除成功");
        } catch (Exception e) {
            if (HttpStatus.INTERNAL_SERVER_ERROR.value() == 500) {
                return ResponseEntity.status(500).body("500错误：该离职记录无法删除");
            } else {
                return ResponseEntity.status(500).body("发生错误：" + e.getMessage());
            }
        }
    }

    @GetMapping(value = "/findbyID")
    public Dimission findbyID(@RequestParam int emp_ID) {
        Dimission dim = dimService.findbyID(emp_ID);
        return dim;
    }

    @GetMapping(value = "/findbypos")
    public List<Dimission> findbypos(@RequestParam int pos_ID) {
        return dimService.findbypos(pos_ID);
    }

    @GetMapping(value = "/findbydep")
    public List<Dimission> findbydep(@RequestParam int dep_ID) {
        return dimService.findbydep(dep_ID);
    }

    @GetMapping(value = "/findByDateRange")
    public List<Dimission> findByDateRange(@RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                           @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return dimService.findByDateRange(startDate, endDate);

    }


}
