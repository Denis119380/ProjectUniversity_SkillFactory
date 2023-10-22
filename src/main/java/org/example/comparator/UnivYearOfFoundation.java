package org.example.comparator;

import org.example.University;

public class UnivYearOfFoundation implements UniversityComparator{
    @Override
    public int compare(University un1, University un2) {
        return Integer.compare(un1.getYearOfFoundation(), un2.getYearOfFoundation());
    }
}
