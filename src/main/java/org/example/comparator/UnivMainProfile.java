package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.University;

public class UnivMainProfile implements UniversityComparator{
    @Override
    public int compare(University un1, University un2) {
        return StringUtils.compare(un1.getMainProfile().toString(), un2.getMainProfile().toString());
    }
}
