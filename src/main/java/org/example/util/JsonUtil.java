package org.example.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.example.model.Statistics;
import org.example.model.Student;
import org.example.model.University;

import java.util.List;

public class JsonUtil {
    private JsonUtil() {
    }

    public static String universityToJson(University university) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);
    }

    public static String studentToJson(Student student) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);
    }

    public static University jsonToUniversity(String json) {
        return new Gson().fromJson(json, University.class);
    }

    public static Student jsonToStudent(String json) {
        return new Gson().fromJson(json, Student.class);
    }

    public static String universitiesListToJson(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);
    }

    public static String studentsListToJson(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);
    }

    public static String statisticsListToJson(List<Statistics> statistics) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(statistics);
    }
    public static String writeListToJson(List<?> list) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(list);
    }

    public static List<University> jsonToUniversitiesList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }

    public static List<Student> jsonToStudentsList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

}
