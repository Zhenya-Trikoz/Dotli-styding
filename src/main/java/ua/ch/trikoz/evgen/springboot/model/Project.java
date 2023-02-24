package ua.ch.trikoz.evgen.springboot.model;

import java.sql.Timestamp;

public class Project {
    private String projectName;
    private String timestamp;
    private int compilationTime;
    private String result;

    public Project(String projectName, String timestamp, int compilationTime, String result) {
        this.projectName = projectName;
        this.timestamp = timestamp;
        this.compilationTime = compilationTime;
        this.result = result;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getCompilationTime() {
        return compilationTime;
    }

    public void setCompilationTime(int compilationTime) {
        this.compilationTime = compilationTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
