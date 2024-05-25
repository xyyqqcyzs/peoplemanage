package com.sawyer.service;

import com.sawyer.dao.EmpDAO;
import com.sawyer.entity.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.Row;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ReportService {
    private final EmpDAO empDAO;

   @Autowired
    public ReportService(EmpDAO empDAO) {
        this.empDAO = empDAO;
    }

    public String generateEmployeeReport(List<Integer> employeeIds) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employee Report");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Employee ID");
        headerRow.createCell(1).setCellValue("Employee Name");
        headerRow.createCell(2).setCellValue("Gender");
        headerRow.createCell(3).setCellValue("Department ID");
        headerRow.createCell(4).setCellValue("Department Name");
        headerRow.createCell(5).setCellValue("Position ID");
        headerRow.createCell(6).setCellValue("Position Name");
        headerRow.createCell(7).setCellValue("Join Date");
        headerRow.createCell(8).setCellValue("Enter Mode");
        headerRow.createCell(9).setCellValue("Birthday");
        headerRow.createCell(10).setCellValue("Phone");
        headerRow.createCell(11).setCellValue("Email");
        headerRow.createCell(12).setCellValue("Address");
        headerRow.createCell(13).setCellValue("Work Experience");
        headerRow.createCell(14).setCellValue("Academic Background");
        headerRow.createCell(15).setCellValue("Employee Type");
        headerRow.createCell(16).setCellValue("Confirmation Date");
        headerRow.createCell(17).setCellValue("Intern Situation");
        headerRow.createCell(18).setCellValue("Intern Detail");

        // Fill data rows
        int rowNum = 1;
        for (Integer empId : employeeIds) {
            Employee employee = empDAO.findbyID(empId);
            if (employee != null) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(employee.getEmp_ID());
                row.createCell(1).setCellValue(employee.getEmp_name());
                row.createCell(2).setCellValue(employee.getGender());
                row.createCell(3).setCellValue(employee.getDep_ID());
                row.createCell(4).setCellValue(employee.getDep_name());
                row.createCell(5).setCellValue(employee.getPos_ID());
                row.createCell(6).setCellValue(employee.getPos_name());
                row.createCell(7).setCellValue(employee.getDate().toString());
                row.createCell(8).setCellValue(employee.getEntermode());
                row.createCell(9).setCellValue(employee.getBirthday().toString());
                row.createCell(10).setCellValue(employee.getPhone());
                row.createCell(11).setCellValue(employee.getEmail());
                row.createCell(12).setCellValue(employee.getAddress());
                row.createCell(13).setCellValue(employee.getWork_experience());
                row.createCell(14).setCellValue(employee.getAcademic_background());
                row.createCell(15).setCellValue(employee.getEmp_type());
                row.createCell(16).setCellValue(employee.getConfirm_date().toString());
                row.createCell(17).setCellValue(employee.getIntern_situation());
                row.createCell(18).setCellValue(employee.getIntern_detail());
            }
        }

        // Write to file
        String fileName = "employee_report.xlsx";
        try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
            workbook.write(fileOut);
        }

        return fileName;
    }
}
