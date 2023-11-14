package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.enums.StudEnumComparators;
import org.example.enums.UnivEnumComparators;
import org.example.io.ReadUnivStud;
import org.example.io.XlsWriter;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;
import org.example.util.StatisticUtil;
import org.example.util.Utility;

import java.io.IOException;
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

        List<University> list = ReadUnivStud.readUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = Utility.getUnivComparator(UnivEnumComparators.UNIV_YEAR_OF_FOUNDATION);
        list.sort(universityComparator);

        List<Student> list1 = ReadUnivStud.readStudent("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Utility.getStudComparator(StudEnumComparators.STUD_AVG_EXAM_SCORE);

        List<Statistics> statistics = StatisticUtil.methStatistic(list, list1);
        XlsWriter.write(statistics, "statistics.xlsx");

        logger.log(Level.INFO, "Ending application.");
    }
}