package com.sawyer.swagger.controller;

import com.sawyer.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {
    private final ReportService reportService;

    @Autowired
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping("/employee/report")
    public String generateEmployeeReport(@RequestBody List<Integer> employeeIds) {
        try {
            return reportService.generateEmployeeReport(employeeIds);
        } catch (IOException e) {
            e.printStackTrace();
            return "Error occurred while generating report.";
        }
    }
}

