package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.enums.StudEnumComparators;
import org.example.enums.UnivEnumComparators;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<University> list = ReadUnivStud.readUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = Utility.getUnivComparator(UnivEnumComparators.UNIV_YEAR_OF_FOUNDATION);
        list.stream().sorted(universityComparator).forEach(System.out :: println);

        List<Student> list1 = ReadUnivStud.readStudent("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Utility.getStudComparator(StudEnumComparators.STUD_AVG_EXAM_SCORE);
        list1.stream().sorted(studentComparator).forEach(System.out :: println);
    }
}