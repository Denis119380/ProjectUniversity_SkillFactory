package org.example.model;

import jakarta.xml.bind.annotation.*;

import java.util.Date;
import java.util.List;

@XmlRootElement(name = "root")
@XmlAccessorType(XmlAccessType.FIELD)
public class GeneralInfo {
    @XmlElementWrapper(name = "universitiesInfo")
    @XmlElement(name = "universityEntry")
    private List<University> universityList;
    @XmlElementWrapper(name = "studentsInfo")
    @XmlElement(name = "studentEntry")
    private List<Student> studentList;
    @XmlElementWrapper(name = "statisticalInfo")
    @XmlElement(name = "statisticsEntry")
    private List<Statistics> statisticsList;
    @XmlElement(name = "processedAt")
    private Date date;

    public GeneralInfo() {
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Statistics> getStatisticsList() {
        return statisticsList;
    }

    public void setStatisticsList(List<Statistics> statisticsList) {
        this.statisticsList = statisticsList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
