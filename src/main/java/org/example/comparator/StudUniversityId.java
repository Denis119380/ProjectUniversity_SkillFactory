package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.Student;

public class StudUniversityId implements StudentComparator{
    @Override
    public int compare(Student st1, Student st2) {
        return StringUtils.compare(st1.getUniversityId(), st2.getUniversityId());
    }
}
