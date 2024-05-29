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
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.ss.usermodel.Row;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class RepServiceImpl implements RepService {

    @Autowired
    private ReportDAO reportDAO;

    @Override  //查找所有
    public ByteArrayInputStream findAll() throws IOException {
        List<Employee> employees = reportDAO.findAll();

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row
            String[] headers = {"Emp_ID", "Emp_Name", "Gender", "Dep_ID", "Dep_Name", "Pos_ID", "Pos_Name", "Date",
                    "EnterMode", "Birthday", "Phone", "Email", "Address", "Work_Experience",
                    "Academic_Background", "Emp_Type", "Confirm_Date", "Intern_Situation", "Intern_Detail"};
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Fill data rows
            int rowIdx = 1;
            for (Employee employee : employees) {
                Row row = sheet.createRow(rowIdx++);

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

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    @Override  //按部门查找
    public ByteArrayInputStream findbydep(int dep_ID) throws IOException {
        List<Employee> employees = reportDAO.findbydep(dep_ID);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row
            String[] headers = {"Emp_ID", "Emp_Name", "Gender", "Dep_ID", "Dep_Name", "Pos_ID", "Pos_Name", "Date",
                    "EnterMode", "Birthday", "Phone", "Email", "Address", "Work_Experience",
                    "Academic_Background", "Emp_Type", "Confirm_Date", "Intern_Situation", "Intern_Detail"};
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Fill data rows
            int rowIdx = 1;
            for (Employee employee : employees) {
                Row row = sheet.createRow(rowIdx++);

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

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    @Override  //按岗位查找
    public ByteArrayInputStream findbypos(int pos_ID) throws IOException {
        List<Employee> employees = reportDAO.findbypos(pos_ID);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row
            String[] headers = {"Emp_ID", "Emp_Name", "Gender", "Dep_ID", "Dep_Name", "Pos_ID", "Pos_Name", "Date",
                    "EnterMode", "Birthday", "Phone", "Email", "Address", "Work_Experience",
                    "Academic_Background", "Emp_Type", "Confirm_Date", "Intern_Situation", "Intern_Detail"};
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Fill data rows
            int rowIdx = 1;
            for (Employee employee : employees) {
                Row row = sheet.createRow(rowIdx++);

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

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    @Override  //按入职日期查找
    public ByteArrayInputStream findByDate(Date startDate, Date endDate) throws IOException {
        List<Employee> employees = reportDAO.findByDate(startDate, endDate);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row
            String[] headers = {"Emp_ID", "Emp_Name", "Gender", "Dep_ID", "Dep_Name", "Pos_ID", "Pos_Name", "Date",
                    "EnterMode", "Birthday", "Phone", "Email", "Address", "Work_Experience",
                    "Academic_Background", "Emp_Type", "Confirm_Date", "Intern_Situation", "Intern_Detail"};
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Fill data rows
            int rowIdx = 1;
            for (Employee employee : employees) {
                Row row = sheet.createRow(rowIdx++);

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

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    @Override  //按转正日期查找
    public ByteArrayInputStream findByConDate(Date startDate, Date endDate) throws IOException {
        List<Employee> employees = reportDAO.findByConDate(startDate, endDate);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Employees");

            // Create header row
            String[] headers = {"Emp_ID", "Emp_Name", "Gender", "Dep_ID", "Dep_Name", "Pos_ID", "Pos_Name", "Date",
                    "EnterMode", "Birthday", "Phone", "Email", "Address", "Work_Experience",
                    "Academic_Background", "Emp_Type", "Confirm_Date", "Intern_Situation", "Intern_Detail"};
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Fill data rows
            int rowIdx = 1;
            for (Employee employee : employees) {
                Row row = sheet.createRow(rowIdx++);

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

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

}
