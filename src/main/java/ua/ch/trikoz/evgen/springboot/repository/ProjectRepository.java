package ua.ch.trikoz.evgen.springboot.repository;

import org.springframework.stereotype.Repository;
import ua.ch.trikoz.evgen.springboot.model.Project;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ProjectRepository {

    private final Set<Project> project = new HashSet<>();

    public Collection<Project> getAll() {
        return Collections.unmodifiableSet(project);
    }

    public List<Project> getProjects() {
        return project.stream().toList();
    }

    public void add(String projectName, int compilationTime, String result) {
        Project projectNew = new Project(projectName, getDataAndTime(), compilationTime, result);
        project.add(projectNew);
    }

    public List<Project> getFailedResult() {
        List<Project> listFailedResult = new ArrayList<>();
        for (Project project : project) {
            if (!project.getResult().equals("success")) {
                listFailedResult.add(project);
            }
        }
        return listFailedResult;
    }

    public List<Project> getSuccessResult() {
        List<Project> listSuccessResult = new ArrayList<>();
        for (Project project : project) {
            if (project.getResult().equals("success")) {
                listSuccessResult.add(project);
            }
        }
        return listSuccessResult;
    }

    public List<Project> getLongCompilation() {
        List<Project> listLongCompilation = new ArrayList<>();
        for (Project project : project) {
            if (project.getCompilationTime() >= 1000) {
                listLongCompilation.add(project);
            }
        }
        return listLongCompilation;
    }

    public List<Project> getNormalCompilation() {
        List<Project> listNormalCompilation = new ArrayList<>();
        for (Project project : project) {
            if (project.getCompilationTime() < 1000) {
                listNormalCompilation.add(project);
            }
        }
        return listNormalCompilation;
    }

    public static String getDataAndTime() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }

}
