package org.example.comparator;

import org.apache.commons.lang3.StringUtils;
import org.example.University;

public class UnivId implements UniversityComparator{
    @Override
    public int compare(University un1, University un2){
        return StringUtils.compare(un1.getId(), un2.getId());
    }
}
