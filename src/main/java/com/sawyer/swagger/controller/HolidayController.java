package com.sawyer.swagger.controller;

import com.sawyer.entity.*;
import com.sawyer.entity.Process;
import com.sawyer.service.EmpService;
import com.sawyer.service.EmpmovService;
import com.sawyer.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RestController
@RequestMapping(value = "/holiday")
public class HolidayController {
    @Autowired
    private HolidayService holService;
    @Autowired
    private EmpService empService;
    private Employee emp;

    @GetMapping(value = "/findAll")
    public List<Holiday> findAll() {
        List<Holiday> allList = holService.findAll();
        return allList;
    }
    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody Holiday hol) {
        holService.add(hol);
        return ResponseEntity.ok("添加成功");
    }

    @PostMapping(value = "/process")
    public ResponseEntity<String> process(@RequestBody Process process) {
        //获得处理日期和要处理的申请id
        int idd = process.getId();
        Date date = process.getDate();
        //根据id获得假期申请表里对应的记录
        Holiday hol = holService.findbyID(idd);
        //获取申请员工
        int id = hol.getEmp_ID();
        this.emp = empService.findbyID(id);
        //计算要休假的天数
        long dateDiff = ChronoUnit.DAYS.between(hol.getStart_date().toLocalDate(),hol.getEnd_date().toLocalDate());
        int dateDiffInteger = Long.valueOf(dateDiff).intValue();
        //获取要休假的类型：年假/调休假
        String type = hol.getType();
        //计算休假后，剩余年假/调休假天数
        if(type.equals("年假")){
            System.out.println(this.emp.getAnnual_holiday());
            int new_days = this.emp.getAnnual_holiday() - dateDiffInteger;
            this.emp.setAnnual_holiday(new_days);
        }else if(type.equals("调休")){
            int news_days = emp.getLieu_holiday() - dateDiffInteger;
            emp.setLieu_holiday(news_days);
        }
        //更新员工表里的年假/调休假天数
        empService.update(emp);
        //设置申请记录为已处理
        hol.setProcess_state("已处理");
        hol.setProcess_date(date);
        holService.update(hol);
        return ResponseEntity.ok("已处理");
    }

    //拒绝请假申请
   @PostMapping(value="/reject")
    public ResponseEntity<String> reject(@RequestBody Process process) {
        int idd = process.getId();
        Date date = process.getDate();
        Holiday hol = holService.findbyID(idd);
        hol.setProcess_state("已拒绝");
        hol.setProcess_date(date);
        holService.update(hol);
        return ResponseEntity.ok("已处理");
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<String> delete(@RequestParam int hol_ID) {
        holService.delete(hol_ID);
        return ResponseEntity.ok("删除成功");
    }


    @GetMapping(value = "/findbyemp")
    public List<Holiday> findbyemp(@RequestParam int emp_ID) {
        List<Holiday> allList = holService.findbyemp(emp_ID);
        return allList;
    }
    @GetMapping(value = "/findbyprocess")
    public List<Holiday> findbyprocess(@RequestParam String process_state) {
        List<Holiday> allList = holService.findbyprocess(process_state);
        return allList;
    }

}
