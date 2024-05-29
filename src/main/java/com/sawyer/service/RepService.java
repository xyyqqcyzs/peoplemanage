package com.sawyer.service;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.IOException;
import java.io.ByteArrayInputStream;
import com.sawyer.entity.Employee;

import java.util.Date;
import java.util.List;

public interface RepService {

    ByteArrayInputStream findAll() throws IOException;

    ByteArrayInputStream findbydep(int dep_ID) throws IOException;

    ByteArrayInputStream findbypos(int pos_ID) throws IOException;

    ByteArrayInputStream findByDate(Date startDate, Date endDate) throws IOException;

    ByteArrayInputStream findByConDate(Date startDate, Date endDate) throws IOException;

}
