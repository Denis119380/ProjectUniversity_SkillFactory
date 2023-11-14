package org.example.io;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;
import org.example.model.Statistics;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsWriter {
    private XlsWriter() {
    }
    private static final Logger logger = Logger.getLogger(XlsWriter.class.getName());
    public static void write(List<Statistics> statistics, String path) {
        logger.log(Level.INFO, "Writing start.");

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Статистика");

        XSSFFont font1 = workbook.createFont();
        font1.setBold(true);
        font1.setFontHeightInPoints((short)14);
        XSSFCellStyle style1 = workbook.createCellStyle();
        style1.setFont(font1);

        int number = 0;
        Row row1 = sheet.createRow(number++);
        Cell cell1Row1 = row1.createCell(0);
        cell1Row1.setCellValue("Профиль");
        cell1Row1.setCellStyle(style1);

        Cell cell2Row1 = row1.createCell(1);
        cell2Row1.setCellValue("Средний балл");
        cell2Row1.setCellStyle(style1);

        Cell cell3Row1 = row1.createCell(2);
        cell3Row1.setCellValue("Кол-во студентов");
        cell3Row1.setCellStyle(style1);

        Cell cell4Row1 = row1.createCell(3);
        cell4Row1.setCellValue("Кол-во университетов");
        cell4Row1.setCellStyle(style1);

        Cell cell5Row1 = row1.createCell(4);
        cell5Row1.setCellValue("Университеты");
        cell5Row1.setCellStyle(style1);

        for (Statistics statistic : statistics) {
            Row row2 = sheet.createRow(number++);
            Cell cell1Row2 = row2.createCell(0);
            cell1Row2.setCellValue(statistic.getMainProfile().getDescription());

            Cell cell2Row2 = row2.createCell(1);
            cell2Row2.setCellValue(statistic.getAvgExamScore());

            Cell cell3Row2 = row2.createCell(2);
            cell3Row2.setCellValue(statistic.getNumberStudentsProfile());

            Cell cell4Row2 = row2.createCell(3);
            cell4Row2.setCellValue(statistic.getNumberUniversitiesProfile());

            Cell cell5Row2 = row2.createCell(4);
            cell5Row2.setCellValue(statistic.getFullName());

        }
        try (FileOutputStream fos = new FileOutputStream(path)){
            workbook.write(fos);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Writing failed.", e);
            return;
        }
        logger.log(Level.INFO, "Writing end. Successful.");
    }
}
