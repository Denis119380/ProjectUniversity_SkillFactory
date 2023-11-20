package org.example.io;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;
import org.example.model.Student;
import org.example.model.University;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class XlsReader {

    private XlsReader() {

    }

    private static final Logger logger = Logger.getLogger(XlsReader.class.getName());

    public static List<University> readUniversity(String filePath) {
        List<University> list = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(filePath)) {
            logger.log(Level.INFO, "Reading start. Universities.");

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet("Университеты");

            Iterator<Row> rows = xssfSheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentrow = rows.next();
                University university = new University();
                list.add(university);
                university.setId(currentrow.getCell(0).getStringCellValue());
                university.setFullName(currentrow.getCell(1).getStringCellValue());
                university.setShortName(currentrow.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) currentrow.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(currentrow.getCell(4).getStringCellValue()));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Reading error. Universities", e);
            return null;
        }
        logger.log(Level.INFO, "Reading end. Universities.");
        return list;
    }

    public static List<Student> readStudent(String filePath) {
        List<Student> list = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            logger.log(Level.INFO, "Reading start. Students.");

            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fis);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet("Студенты");

            Iterator<Row> rows = xssfSheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentrow = rows.next();
                Student student = new Student();
                list.add(student);
                student.setUniversityId(currentrow.getCell(0).getStringCellValue());
                student.setFullName(currentrow.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) currentrow.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) currentrow.getCell(3).getNumericCellValue());
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Reading error. Students.", e);
            return null;
        }
        logger.log(Level.INFO, "Reading end. Students.");
        return list;
    }
}
