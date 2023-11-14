package org.example.util;

import org.apache.commons.lang3.StringUtils;
import org.example.enums.StudyProfile;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StatisticUtil {
    private StatisticUtil() {
    }
    private static final Logger logger = Logger.getLogger(StatisticUtil.class.getName());
    public static List<Statistics> methStatistic(List<University> universities, List<Student> students) {

        logger.log(Level.INFO, "Method start. Statistic.");

        List<Statistics> statisticsList = new ArrayList<>();

        Set<StudyProfile> profiles = universities.stream().map(University::getMainProfile).collect(Collectors.toSet());

        profiles.forEach(profile -> {
            Statistics statistics = new Statistics();
            statisticsList.add(statistics);
            statistics.setMainProfile(profile);

            List<String> profUnivId = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile))
                    .map(University::getId)
                    .collect(Collectors.toList());

            statistics.setNumberUniversitiesProfile(profUnivId.size());
            statistics.setFullName(StringUtils.EMPTY);

            universities.stream()
                    .filter(university -> profUnivId.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setFullName(
                            statistics.getFullName() + fullNameUniversity + ";"));

            List<Student> profStud = students.stream()
                    .filter(student -> profUnivId.contains(student.getUniversityId()))
                    .collect(Collectors.toList());

            statistics.setNumberStudentsProfile(profStud.size());

            OptionalDouble avgExamScore = profStud.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();

            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore((float) BigDecimal.valueOf(value)
                    .setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });
        logger.log(Level.INFO, "Method end. Statistic.");
        return statisticsList;
    }
}
