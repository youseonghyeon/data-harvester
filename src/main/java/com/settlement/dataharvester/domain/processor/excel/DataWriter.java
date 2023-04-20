package com.settlement.dataharvester.domain.processor.excel;

import com.settlement.dataharvester.domain.dto.report.DailyReportData;
import com.settlement.dataharvester.domain.dto.report.MonthlyReportData;
import com.settlement.dataharvester.domain.dto.report.WeeklyReportData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;

public class DataWriter {

    public void writeDailyReport(DailyReportData dailyTemplate, String fullPath) {
        File file = new File(fullPath);
        Workbook workbook = ExcelUtils.createWorkbook(file);
        Sheet sheet = workbook.createSheet(dailyTemplate.getTitle());
        ExcelUtils.insert(sheet, 0, 0, dailyTemplate.getDate());
        // TODO ~
    }

    public void writeWeeklyReport(WeeklyReportData weeklyTemplate, String fullPath) {
        File file = new File(fullPath);
        Workbook workbook = ExcelUtils.createWorkbook(file);
        Sheet sheet = workbook.createSheet(weeklyTemplate.getTitle());
        ExcelUtils.insert(sheet, 0, 0, weeklyTemplate.getStartDay());
        // TODO ~
    }

    public void writeMonthlyReport(MonthlyReportData monthlyTemplate, String fullPath) {
        File file = new File(fullPath);
        Workbook workbook = ExcelUtils.createWorkbook(file);
        Sheet sheet = workbook.createSheet(monthlyTemplate.getTitle());
        ExcelUtils.insert(sheet, 0, 0, monthlyTemplate.getMonth());
        // TODO ~
    }
}
