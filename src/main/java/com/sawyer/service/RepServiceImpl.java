package com.sawyer.service;

import com.sawyer.entity.Employee;
import com.sawyer.dao.ReportDAO;
import com.sawyer.service.RepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.Row;

@Service
@Transactional
public class RepServiceImpl implements RepService {

    @Autowired
    private ReportDAO reportDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Employee> findbydep(int dep_id) {
        return reportDAO.findbydep(dep_id);
    }

    @Override
    public List<Employee> findbypos(int pos_ID) {
        return reportDAO.findbypos(pos_ID);
    }




    //生成表格
//    @Override
//    public Workbook generateExcelReport(List<Employee> employees) {
//        Workbook workbook = new XSSFWorkbook();
//        Sheet sheet = workbook.createSheet("Employee Report");
//
//        // Create header row
//        Row headerRow = sheet.createRow(0);
//        String[] headers = {"ID", "Name", "Gender", "Department ID", "Department Name", "Position ID", "Position Name", "Date", "Enter Mode", "Birthday", "Phone", "Email", "Address", "Work Experience", "Academic Background", "Employee Type", "Confirm Date", "Intern Situation", "Intern Detail"};
//        for (int i = 0; i < headers.length; i++) {
//            Cell cell = headerRow.createCell(i);
//            cell.setCellValue(headers[i]);
//        }
//
//        // Fill data rows
//        int rowNum = 1;
//        for (Employee emp : employees) {
//            Row row = sheet.createRow(rowNum++);
//            row.createCell(0).setCellValue(emp.getEmp_ID());
//            row.createCell(1).setCellValue(emp.getEmp_name());
//            row.createCell(2).setCellValue(emp.getGender());
//            row.createCell(3).setCellValue(emp.getDep_ID());
//            row.createCell(4).setCellValue(emp.getDep_name());
//            row.createCell(5).setCellValue(emp.getPos_ID());
//            row.createCell(6).setCellValue(emp.getPos_name());
//            row.createCell(7).setCellValue(emp.getDate().toString());
//            row.createCell(8).setCellValue(emp.getEntermode());
//            row.createCell(9).setCellValue(emp.getBirthday().toString());
//            row.createCell(10).setCellValue(emp.getPhone());
//            row.createCell(11).setCellValue(emp.getEmail());
//            row.createCell(12).setCellValue(emp.getAddress());
//            row.createCell(13).setCellValue(emp.getWork_experience());
//            row.createCell(14).setCellValue(emp.getAcademic_background());
//            row.createCell(15).setCellValue(emp.getEmp_type());
//            row.createCell(16).setCellValue(emp.getConfirm_date().toString());
//            row.createCell(17).setCellValue(emp.getIntern_situation());
//            row.createCell(18).setCellValue(emp.getIntern_detail());
//        }
//        return workbook;
//    }

}
