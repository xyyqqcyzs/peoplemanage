package com.sawyer.swagger.controller;


import com.sawyer.entity.Career;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Findemp;
import com.sawyer.service.EmpService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;


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


    //多值查询：部门ID，岗位ID，入职日期，转正日期，入职方式（人才库入职，普通入职），
    // 员工类型（正式员工，实习生），实习情况（正常实习，延期，未通过，已转正）
    @PostMapping(value = "/findbyall")
    public List<Employee> findbyall(@RequestBody Findemp find) {
        Integer dep_ID = find.getDep_ID(); // Integer 类型可接受 null 值
        Integer pos_ID = find.getPos_ID();
        String datea = find.getDatea();
        String dateb = find.getDateb();
        String entermode = find.getEntermode();
        String emp_type = find.getEmp_type();
        String confirm_datea = find.getConfirm_datea();
        String confirm_dateb = find.getConfirm_dateb();
        String intern_situation = find.getIntern_situation();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        java.sql.Date sqlDateA = null;
        java.sql.Date sqlDateB = null;
        java.sql.Date sqlConfirmDateA = null;
        java.sql.Date sqlConfirmDateB = null;

        try {
            if(datea!=null){
            java.util.Date utilDateA = sdf.parse(datea);
            sqlDateA = new java.sql.Date(utilDateA.getTime());}

            if (dateb!=null){
            java.util.Date utilDateB = sdf.parse(dateb);
            sqlDateB = new java.sql.Date(utilDateB.getTime());}

            if(confirm_datea!=null){
            java.util.Date utilConfirmDateA = sdf.parse(confirm_datea);
            sqlConfirmDateA = new java.sql.Date(utilConfirmDateA.getTime());}

           if(confirm_dateb!=null){
            java.util.Date utilConfirmDateB = sdf.parse(confirm_dateb);
            sqlConfirmDateB = new java.sql.Date(utilConfirmDateB.getTime());}

        } catch (ParseException e) {
            e.printStackTrace();
            //处理可能的 ParseException 异常
        }

        // Check if the values are null and set them to null if needed
        if ("".equals(entermode)) {
            entermode = null;
        }
        if ("".equals(emp_type)) {
            emp_type = null;
        }
        if ("".equals(intern_situation)) {
            intern_situation = null;
        }
        // Repeat the null check and conversion for other fields
        List<Employee> allList = empService.findbyall(dep_ID, pos_ID, sqlDateA, sqlDateB,entermode, emp_type, sqlConfirmDateA, sqlConfirmDateB, intern_situation);
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
    @GetMapping(value = "/findbyMode")
    public List<Employee> findbyMode(@RequestParam String mode){
        List<Employee> allList = empService.findbyMode(mode);
        return allList;
    }

    //根据员工类型查询（实习生，正式员工）
    @GetMapping(value = "/findbyemptype")
    public List<Employee> findbyemptype(@RequestParam String emp_type){
        List<Employee> allList = empService.findbyemptype(emp_type);
        return allList;
    }
    /*@PostMapping(value = "findbyemptype")
    public ResponseEntity<List<Employee>> findbyemptype(@RequestParam String emp_type){
        List<Employee> allList = empService.findbyemptype(emp_type);
        return ResponseEntity.ok(allList);
    }*/



    //添加员工,普通入职
     /* @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Employee emp) {
        MultipartFile photo = emp.getPhoto();
        String randonumber = UUID.randomUUID().toString().replace("-","");
        String oldfipename = photo.getOriginalFilename();
        String extension  = FilenameUtils.getExtension(photo.getOriginalFilename());
        String newFilename = randonumber + "." + extension;

        File datedir = new File(uploadFolder);
        empService.add(emp);
        return ResponseEntity.ok("添加成功");
    }*/
  @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Employee emp) {
        empService.add(emp);
        return ResponseEntity.ok("添加成功");
    }


    //删除员工
    @DeleteMapping (value = "/delete")
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

    //根据ID查询员工学业背景和工作经历
    @GetMapping(value="/findcareer")
    public Career findcareer(@RequestParam int id){
        Career career = empService.findcareer(id);
        return career;
    }

    @PutMapping(value = "/update")//更新值不能为空
    public ResponseEntity<String> update(@RequestBody Employee emp) {
        empService.update(emp);
        return ResponseEntity.ok("更新成功");
    }

}
