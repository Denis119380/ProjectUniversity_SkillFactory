package org.example.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import org.example.enums.StudyProfile;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    private StudyProfile mainProfile;
    @XmlElement(name = "avgScore")
    private float avgExamScore;
    @XmlTransient
    private int numberStudentsProfile;
    @XmlTransient
    private int numberUniversitiesProfile;
    @XmlTransient
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
