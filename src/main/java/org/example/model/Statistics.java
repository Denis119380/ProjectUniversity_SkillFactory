package org.example.model;

import org.example.enums.StudyProfile;

public class Statistics {
    private StudyProfile mainProfile;
    private float avgExamScore;
    private int numberStudentsProfile;
    private int numberUniversitiesProfile;
    private String fullName;

    public Statistics() {
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    public int getNumberStudentsProfile() {
        return numberStudentsProfile;
    }

    public void setNumberStudentsProfile(int numberStudentsProfile) {
        this.numberStudentsProfile = numberStudentsProfile;
    }

    public int getNumberUniversitiesProfile() {
        return numberUniversitiesProfile;
    }

    public void setNumberUniversitiesProfile(int numberUniversitiesProfile) {
        this.numberUniversitiesProfile = numberUniversitiesProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
