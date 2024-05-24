package com.sawyer.swagger.controller;

import com.sawyer.entity.Department;
import com.sawyer.entity.Position;
import com.sawyer.service.DepService;
import com.sawyer.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/position")
public class PositionController {

    @Autowired
    private PosService posService;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<Position> findAll() {
        List<Position> allList = posService.findAll();
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
    public String add(Position pos) {
        posService.add(pos);
        return "添加成功！";
    }

    @GetMapping(value = "/delete")
    public String delete(int id) {
        try {
            posService.delete(id);
            return "删除成功！";
        } catch (Exception e) {
            if (HttpStatus.INTERNAL_SERVER_ERROR.value() == 500) {
                return "500错误：该部门无法删除";
            } else {
                return "发生错误：" + e.getMessage();
            }
        }
    }

    @GetMapping(value = "/findbyID")
    public Position findbyID(int id, Model model) {
        Position pos = posService.findbyID(id);
        model.addAttribute("Position", pos);
        return pos;
    }
    @GetMapping(value = "/findbydep")
    public List<Position> findbydep(int dep_id) {
        List<Position> allList = posService.findbydep(dep_id);
        return allList;
    }

    @PostMapping(value = "update")
    public String update(Position pos) {
        posService.update(pos);
        return "更新成功！";
    }

}
