package org.example.comparator;

import org.example.model.Student;

public class StudAvgExamScore implements StudentComparator{
    @Override
    public int compare(Student st1, Student st2) {
        return Float.compare(st2.getAvgExamScore(), st1.getAvgExamScore());
    }
}
