package com.sawyer.service;

import com.sawyer.entity.Dimission;
import com.sawyer.entity.Employee;
import com.sawyer.entity.Employeemov;
import com.sawyer.dao.ReportDAO;
import com.sawyer.entity.Employeemov;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

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

//                row.createCell(0).setCellValue(employee.getEmp_ID());
//                row.createCell(1).setCellValue(employee.getEmp_name());
//                row.createCell(2).setCellValue(employee.getGender());
//                row.createCell(3).setCellValue(employee.getDep_ID());
//                row.createCell(4).setCellValue(employee.getDep_name());
//                row.createCell(5).setCellValue(employee.getPos_ID());
//                row.createCell(6).setCellValue(employee.getPos_name());
//                row.createCell(7).setCellValue(employee.getDate().toString());
//                row.createCell(8).setCellValue(employee.getEntermode());
//                row.createCell(9).setCellValue(employee.getBirthday().toString());
//                row.createCell(10).setCellValue(employee.getPhone());
//                row.createCell(11).setCellValue(employee.getEmail());
//                row.createCell(12).setCellValue(employee.getAddress());
//                row.createCell(13).setCellValue(employee.getWork_experience());
//                row.createCell(14).setCellValue(employee.getAcademic_background());
//                row.createCell(15).setCellValue(employee.getEmp_type());
//                row.createCell(16).setCellValue(employee.getConfirm_date().toString());
//                row.createCell(17).setCellValue(employee.getIntern_situation());
//                row.createCell(18).setCellValue(employee.getIntern_detail());
                row.createCell(0).setCellValue(employee.getEmp_ID());
                row.createCell(1).setCellValue(employee.getEmp_name() != null ? employee.getEmp_name() : "");
                row.createCell(2).setCellValue(employee.getGender() != null ? employee.getGender() : "");
                row.createCell(3).setCellValue(employee.getDep_ID());
                row.createCell(4).setCellValue(employee.getDep_name() != null ? employee.getDep_name() : "");
                row.createCell(5).setCellValue(employee.getPos_ID());
                row.createCell(6).setCellValue(employee.getPos_name() != null ? employee.getPos_name() : "");
                row.createCell(7).setCellValue(employee.getDate() != null ? employee.getDate().toString() : "");
                row.createCell(8).setCellValue(employee.getEntermode() != null ? employee.getEntermode() : "");
                row.createCell(9).setCellValue(employee.getBirthday() != null ? employee.getBirthday().toString() : "");
                row.createCell(10).setCellValue(employee.getPhone() != null ? employee.getPhone() : "");
                row.createCell(11).setCellValue(employee.getEmail() != null ? employee.getEmail() : "");
                row.createCell(12).setCellValue(employee.getAddress() != null ? employee.getAddress() : "");
                row.createCell(13).setCellValue(employee.getWork_experience() != null ? employee.getWork_experience() : "");
                row.createCell(14).setCellValue(employee.getAcademic_background() != null ? employee.getAcademic_background() : "");
                row.createCell(15).setCellValue(employee.getEmp_type() != null ? employee.getEmp_type() : "");
                row.createCell(16).setCellValue(employee.getConfirm_date() != null ? employee.getConfirm_date().toString() : "");
                row.createCell(17).setCellValue(employee.getIntern_situation() != null ? employee.getIntern_situation() : "");
                row.createCell(18).setCellValue(employee.getIntern_detail() != null ? employee.getIntern_detail() : "");

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
                row.createCell(1).setCellValue(employee.getEmp_name() != null ? employee.getEmp_name() : "");
                row.createCell(2).setCellValue(employee.getGender() != null ? employee.getGender() : "");
                row.createCell(3).setCellValue(employee.getDep_ID());
                row.createCell(4).setCellValue(employee.getDep_name() != null ? employee.getDep_name() : "");
                row.createCell(5).setCellValue(employee.getPos_ID());
                row.createCell(6).setCellValue(employee.getPos_name() != null ? employee.getPos_name() : "");
                row.createCell(7).setCellValue(employee.getDate() != null ? employee.getDate().toString() : "");
                row.createCell(8).setCellValue(employee.getEntermode() != null ? employee.getEntermode() : "");
                row.createCell(9).setCellValue(employee.getBirthday() != null ? employee.getBirthday().toString() : "");
                row.createCell(10).setCellValue(employee.getPhone() != null ? employee.getPhone() : "");
                row.createCell(11).setCellValue(employee.getEmail() != null ? employee.getEmail() : "");
                row.createCell(12).setCellValue(employee.getAddress() != null ? employee.getAddress() : "");
                row.createCell(13).setCellValue(employee.getWork_experience() != null ? employee.getWork_experience() : "");
                row.createCell(14).setCellValue(employee.getAcademic_background() != null ? employee.getAcademic_background() : "");
                row.createCell(15).setCellValue(employee.getEmp_type() != null ? employee.getEmp_type() : "");
                row.createCell(16).setCellValue(employee.getConfirm_date() != null ? employee.getConfirm_date().toString() : "");
                row.createCell(17).setCellValue(employee.getIntern_situation() != null ? employee.getIntern_situation() : "");
                row.createCell(18).setCellValue(employee.getIntern_detail() != null ? employee.getIntern_detail() : "");
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
                row.createCell(1).setCellValue(employee.getEmp_name() != null ? employee.getEmp_name() : "");
                row.createCell(2).setCellValue(employee.getGender() != null ? employee.getGender() : "");
                row.createCell(3).setCellValue(employee.getDep_ID());
                row.createCell(4).setCellValue(employee.getDep_name() != null ? employee.getDep_name() : "");
                row.createCell(5).setCellValue(employee.getPos_ID());
                row.createCell(6).setCellValue(employee.getPos_name() != null ? employee.getPos_name() : "");
                row.createCell(7).setCellValue(employee.getDate() != null ? employee.getDate().toString() : "");
                row.createCell(8).setCellValue(employee.getEntermode() != null ? employee.getEntermode() : "");
                row.createCell(9).setCellValue(employee.getBirthday() != null ? employee.getBirthday().toString() : "");
                row.createCell(10).setCellValue(employee.getPhone() != null ? employee.getPhone() : "");
                row.createCell(11).setCellValue(employee.getEmail() != null ? employee.getEmail() : "");
                row.createCell(12).setCellValue(employee.getAddress() != null ? employee.getAddress() : "");
                row.createCell(13).setCellValue(employee.getWork_experience() != null ? employee.getWork_experience() : "");
                row.createCell(14).setCellValue(employee.getAcademic_background() != null ? employee.getAcademic_background() : "");
                row.createCell(15).setCellValue(employee.getEmp_type() != null ? employee.getEmp_type() : "");
                row.createCell(16).setCellValue(employee.getConfirm_date() != null ? employee.getConfirm_date().toString() : "");
                row.createCell(17).setCellValue(employee.getIntern_situation() != null ? employee.getIntern_situation() : "");
                row.createCell(18).setCellValue(employee.getIntern_detail() != null ? employee.getIntern_detail() : "");
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
                row.createCell(1).setCellValue(employee.getEmp_name() != null ? employee.getEmp_name() : "");
                row.createCell(2).setCellValue(employee.getGender() != null ? employee.getGender() : "");
                row.createCell(3).setCellValue(employee.getDep_ID());
                row.createCell(4).setCellValue(employee.getDep_name() != null ? employee.getDep_name() : "");
                row.createCell(5).setCellValue(employee.getPos_ID());
                row.createCell(6).setCellValue(employee.getPos_name() != null ? employee.getPos_name() : "");
                row.createCell(7).setCellValue(employee.getDate() != null ? employee.getDate().toString() : "");
                row.createCell(8).setCellValue(employee.getEntermode() != null ? employee.getEntermode() : "");
                row.createCell(9).setCellValue(employee.getBirthday() != null ? employee.getBirthday().toString() : "");
                row.createCell(10).setCellValue(employee.getPhone() != null ? employee.getPhone() : "");
                row.createCell(11).setCellValue(employee.getEmail() != null ? employee.getEmail() : "");
                row.createCell(12).setCellValue(employee.getAddress() != null ? employee.getAddress() : "");
                row.createCell(13).setCellValue(employee.getWork_experience() != null ? employee.getWork_experience() : "");
                row.createCell(14).setCellValue(employee.getAcademic_background() != null ? employee.getAcademic_background() : "");
                row.createCell(15).setCellValue(employee.getEmp_type() != null ? employee.getEmp_type() : "");
                row.createCell(16).setCellValue(employee.getConfirm_date() != null ? employee.getConfirm_date().toString() : "");
                row.createCell(17).setCellValue(employee.getIntern_situation() != null ? employee.getIntern_situation() : "");
                row.createCell(18).setCellValue(employee.getIntern_detail() != null ? employee.getIntern_detail() : "");
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
                row.createCell(1).setCellValue(employee.getEmp_name() != null ? employee.getEmp_name() : "");
                row.createCell(2).setCellValue(employee.getGender() != null ? employee.getGender() : "");
                row.createCell(3).setCellValue(employee.getDep_ID());
                row.createCell(4).setCellValue(employee.getDep_name() != null ? employee.getDep_name() : "");
                row.createCell(5).setCellValue(employee.getPos_ID());
                row.createCell(6).setCellValue(employee.getPos_name() != null ? employee.getPos_name() : "");
                row.createCell(7).setCellValue(employee.getDate() != null ? employee.getDate().toString() : "");
                row.createCell(8).setCellValue(employee.getEntermode() != null ? employee.getEntermode() : "");
                row.createCell(9).setCellValue(employee.getBirthday() != null ? employee.getBirthday().toString() : "");
                row.createCell(10).setCellValue(employee.getPhone() != null ? employee.getPhone() : "");
                row.createCell(11).setCellValue(employee.getEmail() != null ? employee.getEmail() : "");
                row.createCell(12).setCellValue(employee.getAddress() != null ? employee.getAddress() : "");
                row.createCell(13).setCellValue(employee.getWork_experience() != null ? employee.getWork_experience() : "");
                row.createCell(14).setCellValue(employee.getAcademic_background() != null ? employee.getAcademic_background() : "");
                row.createCell(15).setCellValue(employee.getEmp_type() != null ? employee.getEmp_type() : "");
                row.createCell(16).setCellValue(employee.getConfirm_date() != null ? employee.getConfirm_date().toString() : "");
                row.createCell(17).setCellValue(employee.getIntern_situation() != null ? employee.getIntern_situation() : "");
                row.createCell(18).setCellValue(employee.getIntern_detail() != null ? employee.getIntern_detail() : "");
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    @Override  //查找？部门？时间入职的员工
    public ByteArrayInputStream findbydepanddate(int dep_ID, Date startDate, Date endDate) throws IOException {
        List<Employee> employees = reportDAO.findbydepanddate(dep_ID, startDate,  endDate);

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
                row.createCell(1).setCellValue(employee.getEmp_name() != null ? employee.getEmp_name() : "");
                row.createCell(2).setCellValue(employee.getGender() != null ? employee.getGender() : "");
                row.createCell(3).setCellValue(employee.getDep_ID());
                row.createCell(4).setCellValue(employee.getDep_name() != null ? employee.getDep_name() : "");
                row.createCell(5).setCellValue(employee.getPos_ID());
                row.createCell(6).setCellValue(employee.getPos_name() != null ? employee.getPos_name() : "");
                row.createCell(7).setCellValue(employee.getDate() != null ? employee.getDate().toString() : "");
                row.createCell(8).setCellValue(employee.getEntermode() != null ? employee.getEntermode() : "");
                row.createCell(9).setCellValue(employee.getBirthday() != null ? employee.getBirthday().toString() : "");
                row.createCell(10).setCellValue(employee.getPhone() != null ? employee.getPhone() : "");
                row.createCell(11).setCellValue(employee.getEmail() != null ? employee.getEmail() : "");
                row.createCell(12).setCellValue(employee.getAddress() != null ? employee.getAddress() : "");
                row.createCell(13).setCellValue(employee.getWork_experience() != null ? employee.getWork_experience() : "");
                row.createCell(14).setCellValue(employee.getAcademic_background() != null ? employee.getAcademic_background() : "");
                row.createCell(15).setCellValue(employee.getEmp_type() != null ? employee.getEmp_type() : "");
                row.createCell(16).setCellValue(employee.getConfirm_date() != null ? employee.getConfirm_date().toString() : "");
                row.createCell(17).setCellValue(employee.getIntern_situation() != null ? employee.getIntern_situation() : "");
                row.createCell(18).setCellValue(employee.getIntern_detail() != null ? employee.getIntern_detail() : "");
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    @Override  //查找？部门？时间离职的员工
    public ByteArrayInputStream finddimbydate(int dep_ID, Date startDate, Date endDate) throws IOException {
        List<Dimission> dimissions = reportDAO.finddimbydate(dep_ID, startDate,  endDate);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Dimissions");

            // Create header row
            String[] headers = {"Emp_ID","dim_date","dim_reason","Emp_Name", "Gender", "Dep_ID",
                                "Dep_Name", "Pos_ID", "Pos_Name", "Date", "Confirm_Date" };
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Fill data rows
            int rowIdx = 1;
            for (Dimission dimission : dimissions) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(dimission.getEmp_ID());
                row.createCell(1).setCellValue(dimission.getDim_date());
                row.createCell(2).setCellValue(dimission.getDim_reason());
                row.createCell(3).setCellValue(dimission.getEmp_name() != null ? dimission.getEmp_name() : "");
                row.createCell(4).setCellValue(dimission.getGender() != null ? dimission.getGender() : "");
                row.createCell(5).setCellValue(dimission.getDep_ID());
                row.createCell(6).setCellValue(dimission.getDep_name() != null ? dimission.getDep_name() : "");
                row.createCell(7).setCellValue(dimission.getPos_ID());
                row.createCell(8).setCellValue(dimission.getPos_name() != null ? dimission.getPos_name() : "");
                row.createCell(9).setCellValue(dimission.getDate() != null ? dimission.getDate().toString() : "");
                row.createCell(10).setCellValue(dimission.getConfirm_date() != null ? dimission.getConfirm_date().toString() : "");
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    @Override  //查找？时间调动部门或岗位的员工
    public ByteArrayInputStream findmovebydate(Date startDate, Date endDate) throws IOException {
        List<Employeemov> employeemovs = reportDAO.findmovebydate(startDate ,  endDate);

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Employeemovs");

            // Create header row
            String[] headers = {"Mov_ID","Emp_ID","Emp_name","before_dep","before_dep_name", "after_dep", "after_dep_name",
                                "before_pos", "before_pos_name", "after_pos", "after_pos_name", "mov_date" ,"reason"};
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < headers.length; i++) {
                headerRow.createCell(i).setCellValue(headers[i]);
            }

            // Fill data rows
            int rowIdx = 1;
            for (Employeemov employeemov: employeemovs) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(employeemov.getMov_ID());
                row.createCell(1).setCellValue(employeemov.getEmp_ID());
                row.createCell(2).setCellValue(employeemov.getEmp_name()!= null ? employeemov.getBefore_dep_name() : "");
                row.createCell(3).setCellValue(employeemov.getBefore_dep());
                row.createCell(4).setCellValue(employeemov.getBefore_dep_name() != null ? employeemov.getBefore_dep_name() : "");
                row.createCell(5).setCellValue(employeemov.getAfter_dep());
                row.createCell(6).setCellValue(employeemov.getAfter_dep_name() != null ? employeemov.getAfter_dep_name() : "");
                row.createCell(7).setCellValue(employeemov.getBefore_pos());
                row.createCell(8).setCellValue(employeemov.getBefore_pos_name() != null ? employeemov.getBefore_pos_name() : "");
                row.createCell(9).setCellValue(employeemov.getAfter_pos());
                row.createCell(10).setCellValue(employeemov.getAfter_pos_name() != null ? employeemov.getAfter_pos_name().toString() : "");
                row.createCell(11).setCellValue(employeemov.getMov_date() != null ? employeemov.getMov_date().toString() : "");
                row.createCell(12).setCellValue(employeemov.getReason() != null ? employeemov.getReason() : "");
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
