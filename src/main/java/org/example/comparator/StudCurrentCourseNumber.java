package org.example.comparator;

import org.example.Student;

public class StudCurrentCourseNumber implements StudentComparator{
    @Override
    public int compare(Student st1, Student st2) {
        return Integer.compare(st1.getCurrentCourseNumber(), st2.getCurrentCourseNumber());
    }
}
