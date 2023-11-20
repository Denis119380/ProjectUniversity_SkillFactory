package org.example.model;

import com.google.gson.annotations.SerializedName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlTransient;
import org.example.enums.StudyProfile;

@XmlAccessorType(XmlAccessType.FIELD)
public class University {
    @XmlElement(name = "universityId")
    @SerializedName("universityId")
    private String id;
    @XmlElement(name = "universityName")
    @SerializedName("universityName")
    private String fullName;
    @XmlTransient
    @SerializedName("universityShortName")
    private String shortName;
    @XmlTransient
    @SerializedName("universityYearFoundation")
    private int yearOfFoundation;
    @XmlElement(name = "universityProfile")
    @SerializedName("universityProfile")
    private StudyProfile mainProfile;

    public University() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
