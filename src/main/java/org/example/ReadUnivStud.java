package org.example;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.example.enums.StudyProfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadUnivStud {

    private ReadUnivStud() {

    }

    public static List<University> readUniversity(String filePath) throws IOException {
        List<University> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
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
        return list;
    }

    public static List<Student> readStudent(String filePath) throws IOException {
        List<Student> list = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);
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
            student.setCurrentCourseNumber((int)currentrow.getCell(2).getNumericCellValue());
            student.setAvgExamScore((float)currentrow.getCell(3).getNumericCellValue());
        }
        return list;
    }
}
