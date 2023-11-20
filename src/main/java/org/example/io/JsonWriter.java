package org.example.io;

import org.example.model.GeneralInfo;
import org.example.util.JsonUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JsonWriter {
    private JsonWriter(){
    }
    private static final Logger logger = Logger.getLogger(JsonWriter.class.getName());
    public static void writerJson(GeneralInfo info){
        logger.log(Level.INFO, "Json writing stared.");
        try {
            Files.createDirectories(Paths.get("directoryJson"));
            logger.log(Level.INFO, "Created directory successful.");
        } catch (IOException e) {
            logger.log(Level.FINE, "Directory already created.", e);
        }
        writeUniversity(info);
        writeStudents(info);
        writeStatistics(info);
        logger.log(Level.INFO, "Json writing finished successful.");
    }

    private static void writeUniversity(GeneralInfo info) {
        String universitiesJson = JsonUtil.writeListToJson(info.getUniversityList());
        try {
            FileOutputStream fos = new FileOutputStream("directoryJson/universities" + info.getDate().getTime() + ".json");
            fos.write(universitiesJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Universities Java to Json writing failed.");
        }
    }
    private static void writeStudents(GeneralInfo info) {
        String studentsJson = JsonUtil.writeListToJson(info.getStudentList());
        try {
            FileOutputStream fos = new FileOutputStream("directoryJson/students" + info.getDate().getTime() + ".json");
            fos.write(studentsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Students Java to Json writing failed.");
        }
    }
    private static void writeStatistics(GeneralInfo info) {
        String statisticsJson = JsonUtil.writeListToJson(info.getStatisticsList());
        try {
            FileOutputStream fos = new FileOutputStream("directoryJson/statistics" + info.getDate().getTime() + ".json");
            fos.write(statisticsJson.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Statistics Java to Json writing failed.");
        }
    }
}
