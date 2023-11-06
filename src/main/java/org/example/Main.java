package org.example;

import org.example.comparator.StudentComparator;
import org.example.comparator.UniversityComparator;
import org.example.enums.StudEnumComparators;
import org.example.enums.UnivEnumComparators;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<University> list = ReadUnivStud.readUniversity("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator = Utility.getUnivComparator(UnivEnumComparators.UNIV_YEAR_OF_FOUNDATION);
        String jsonUniversities = JsonUtil.universitiesListToJson(list);
        System.out.println(jsonUniversities);
        List<University> newList = JsonUtil.jsonToUniversitiesList(jsonUniversities);
        System.out.println(list.size() == newList.size());
        list.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            System.out.println(JsonUtil.jsonToUniversity(universityJson));
        });


        List<Student> list1 = ReadUnivStud.readStudent("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator = Utility.getStudComparator(StudEnumComparators.STUD_AVG_EXAM_SCORE);
        String jsonStudents = JsonUtil.studentsListToJson(list1);
        System.out.println(jsonStudents);
        List<Student> newList1 = JsonUtil.jsonToStudentsList(jsonStudents);
        System.out.println(list1.size() == newList1.size());
        list1.forEach(student -> {
            String studentJson = JsonUtil.studentToJson(student);
            System.out.println(studentJson);
            System.out.println(JsonUtil.jsonToStudent(studentJson));
        });

        List<Statistics> statistics = StatisticUtil.methStatistic(list, list1);
        XlsWriter.write(statistics, "statistics.xlsx");
    }
}