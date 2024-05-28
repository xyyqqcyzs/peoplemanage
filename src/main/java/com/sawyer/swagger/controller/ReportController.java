package com.sawyer.swagger.controller;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sawyer.entity.Employee;
import com.sawyer.service.RepService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private RepService repService;

    @GetMapping(value = "/findbydep", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> generateExcel() {
        try {
            // 创建一个新的Excel工作簿
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("Sheet1");

            // 创建表头
            Row headerRow = sheet.createRow(0);
            Cell cellA = headerRow.createCell(0);
            cellA.setCellValue("A");
            Cell cellB = headerRow.createCell(1);
            cellB.setCellValue("B");

            // 创建内容
            Row contentRow1 = sheet.createRow(1);
            Cell contentCellA1 = contentRow1.createCell(0);
            contentCellA1.setCellValue(1);
            Cell contentCellB1 = contentRow1.createCell(1);
            contentCellB1.setCellValue(1);

            Row contentRow2 = sheet.createRow(2);
            Cell contentCellA2 = contentRow2.createCell(0);
            contentCellA2.setCellValue(2);
            Cell contentCellB2 = contentRow2.createCell(1);
            contentCellB2.setCellValue(2);

            // 将Excel写入字节数组输出流
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();

            // 设置响应头
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("filename", "test.xlsx");

            // 将Excel文件作为字节数组发送到前端
            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping(value = "/findbydep", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
//    public ResponseEntity<byte[]> findbydep(@RequestParam int dep_ID) {
//        List<Employee> employeeList = repService.findbydep(dep_ID);
//
//        // 初始化Excel工作簿和输出流
//        try (Workbook workbook = new XSSFWorkbook();
//             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
//
//            Sheet sheet = workbook.createSheet("Employees");
//
//            // 创建表头
//            Row headerRow = sheet.createRow(0);
//            String[] headers = {"ID", "Name"};
//            for (int i = 0; i < headers.length; i++) {
//                Cell cell = headerRow.createCell(i);
//                cell.setCellValue(headers[i]);
//            }
//
//            // 填充数据
//            int rowNum = 1;
//            for (Employee employee : employeeList) {
//                Row row = sheet.createRow(rowNum++);
//                row.createCell(0).setCellValue(employee.getEmp_ID());
//                row.createCell(1).setCellValue(employee.getEmp_name());
//                //row.createCell(2).setCellValue(employee.getDep_name());
//            }
//
//            // 将工作簿内容写入字节数组
//            workbook.write(bos);
//            byte[] bytes = bos.toByteArray();
//
//            HttpHeaders headersResponse = new HttpHeaders();
//            headersResponse.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//            headersResponse.setContentDispositionFormData("attachment", "employees.xlsx");
//            return new ResponseEntity<>(bytes, headersResponse, HttpStatus.OK);
//
//        } catch (IOException e) {
//            // 处理异常并返回错误响应
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


}



