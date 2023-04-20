package com.settlement.dataharvester.domain.processor.excel;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExcelUtils {



    public static Workbook createWorkbook(File file) {
        try {
            return WorkbookFactory.create(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void insert(Sheet sheet, int row, int column, T data) {
        Row r = sheet.createRow(row);
        Cell cell = r.createCell(column);
        String str = stringConverter(data);
        cell.setCellValue(str);
    }

    private static <T> String stringConverter(T data) {
        if (data instanceof String) {
            return (String) data;
        } else if (data instanceof LocalDate) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return ((LocalDate) data).format(formatter);
        } else if (data instanceof LocalDateTime) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
            return ((LocalDateTime) data).format(formatter);
        } else {
            return String.valueOf(data);
        }
    }

}
