package com.sawyer.swagger.controller;

import com.sawyer.entity.Department;
import com.sawyer.entity.Position;
import com.sawyer.service.DepService;
import com.sawyer.service.PosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(value = "/add")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody Position pos) {
        posService.add(pos);
        return ResponseEntity.ok("添加成功！");
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int id) {
        try {
            posService.delete(id);
            return ResponseEntity.ok("删除成功！");
        } catch (Exception e) {
            if (HttpStatus.INTERNAL_SERVER_ERROR.value() == 500) {
                return ResponseEntity.status(500).body("500错误：该岗位无法删除");
            } else {
                return ResponseEntity.status(500).body("发生错误：" + e.getMessage());
            }
        }
    }

    @GetMapping(value = "/findbyID")
    public Position findbyID(@RequestParam int id) {
        Position pos = posService.findbyID(id);
        return pos;
    }
    @GetMapping(value = "/findbydep")
    public List<Position> findbydep(@RequestParam int dep_id) {
        List<Position> allList = posService.findbydep(dep_id);
        return allList;
    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> update(@RequestBody Position pos) {
        posService.update(pos);
        return ResponseEntity.ok("更新成功！");
    }

}
