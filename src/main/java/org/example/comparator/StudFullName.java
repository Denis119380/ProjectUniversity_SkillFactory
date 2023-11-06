package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.model.Student;

public class StudFullName implements StudentComparator{
    @Override
    public int compare(Student st1,Student st2) {
        return StringUtils.compare(st1.getFullName(), st2.getFullName());
    }
}
