package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.enums.StudEnumComparators;
import org.example.enums.UnivEnumComparators;
import org.example.io.JsonWriter;
import org.example.io.XlsReader;
import org.example.io.XlsWriter;
import org.example.io.XmlWriter;
import org.example.model.GeneralInfo;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.util.StatisticUtil;
import org.example.util.Utility;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.out.println("Error LogManager. " + e);
        }
        logger.log(Level.INFO, "Starting application.");

        List<University> list = XlsReader.readUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = Utility.getUnivComparator(UnivEnumComparators.UNIV_YEAR_OF_FOUNDATION);
        list.sort(universityComparator);

        List<Student> list1 = XlsReader.readStudent("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Utility.getStudComparator(StudEnumComparators.STUD_AVG_EXAM_SCORE);
        list1.sort(studentComparator);

        List<Statistics> statistics = StatisticUtil.methStatistic(list, list1);
        XlsWriter.write(statistics, "statistics.xlsx");

        GeneralInfo info = new GeneralInfo();
        info.setUniversityList(list);
        info.setStudentList(list1);
        info.setStatisticsList(statistics);
        info.setDate(new Date());

        XmlWriter.writerXml(info);
        JsonWriter.writerJson(info);

        logger.log(Level.INFO, "Ending application.");
    }
}