package com.sawyer.service;
import org.apache.poi.ss.usermodel.Workbook;

import com.sawyer.entity.Employee;
import java.util.List;

public interface RepService {

    //List<Employee> findAll();

    List<Employee> findbydep(int dep_ID);

    List<Employee> findbypos(int pos_ID);

    //Workbook generateExcelReport(List<Employee> employees);

}
