package org.example;

import org.example.comparator.*;
import org.example.enums.StudEnumComparators;
import org.example.enums.UnivEnumComparators;
import org.example.model.Student;
import org.example.model.University;

public class Utility {
    private Utility() {
    };
    public static UniversityComparator getUnivComparator(UnivEnumComparators univEnumComparators) {
        switch (univEnumComparators) {
            case UNIV_ID -> {
                return new UnivId();
            }
            case UNIV_FULL_NAME -> {
                return new UnivFullName();
            }
            case UNIV_SHOT_NAME -> {
                return new UnivShortName();
            }
            case UNIV_YEAR_OF_FOUNDATION -> {
                return new UnivYearOfFoundation();
            }
            case UNIV_MAIN_PROFILE -> {
                return new UnivMainProfile();
            }
            default -> {
                return new UniversityComparator() {
                    @Override
                    public int compare(University o1, University o2) {
                        return 0;
                    }
                };
            }
        }
    }

    public static StudentComparator getStudComparator(StudEnumComparators studEnumComparators) {
        switch (studEnumComparators) {
            case STUD_FULL_NAME -> {
                return new StudFullName();
            }
            case STUD_UNIVERSITY_ID -> {
                return new StudUniversityId();
            }
            case STUD_CURRENT_COURSE_NUMBER -> {
                return new StudCurrentCourseNumber();
            }
            case STUD_AVG_EXAM_SCORE -> {
                return new StudAvgExamScore();
            }
            default -> {
                return new StudentComparator() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return 0;
                    }
                };
            }
        }
    }
}
