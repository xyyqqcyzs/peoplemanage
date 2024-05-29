package com.sawyer.swagger.controller;

import com.sawyer.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Date;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private RepService reportService;

    @GetMapping("/employees")
    public ResponseEntity<InputStreamResource> downloadEmployeeReport() throws IOException {
        ByteArrayInputStream in = reportService.findAll();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=employees.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }

    @GetMapping("/employees/department/{dep_ID}")
    public ResponseEntity<InputStreamResource> downloadDepartmentEmployeeReport(@PathVariable int dep_ID) throws IOException {
        ByteArrayInputStream in = reportService.findbydep(dep_ID);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=department_" + dep_ID + "_employees.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }

    @GetMapping("/employees/position/{pos_ID}")
    public ResponseEntity<InputStreamResource> downloadPositionEmployeeReport(@PathVariable int pos_ID) throws IOException {
        ByteArrayInputStream in = reportService.findbypos(pos_ID);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=position" + pos_ID + "_employees.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }

    @GetMapping("/employees/date")
    public ResponseEntity<InputStreamResource> downloadDateEmployeeReport( @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                                                           @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) throws IOException {
        ByteArrayInputStream in = reportService.findByDate(startDate, endDate);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=dateRange_" + startDate + endDate + "_employees.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }

    @GetMapping("/employees/condate")
    public ResponseEntity<InputStreamResource> downloadConDateEmployeeReport( @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                                                              @RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) throws IOException {
        ByteArrayInputStream in = reportService.findByConDate(startDate, endDate);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename = CondataRange" + startDate + endDate + "_employees.xlsx");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(new InputStreamResource(in));
    }

}