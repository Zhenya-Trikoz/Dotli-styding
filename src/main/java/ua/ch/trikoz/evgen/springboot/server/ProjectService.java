package ua.ch.trikoz.evgen.springboot.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ch.trikoz.evgen.springboot.exception.ProjectRegistrationException;
import ua.ch.trikoz.evgen.springboot.model.Project;
import ua.ch.trikoz.evgen.springboot.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository guestRepository;

    public int getCount() {
        return guestRepository.getAll().size();
    }

    public void register(String projectName, int compilationTime, String result) {
        if (guestRepository.getProjects().contains(projectName)) {
            throw new ProjectRegistrationException(
                    String.format(" Проект %s вже зареєстрований", projectName));
        }
        guestRepository.add(projectName, compilationTime, result);
    }

    public List<Project> getProjects() {
        return guestRepository.getProjects();
    }

    public List<Project> getFailedResult() {
        return guestRepository.getFailedResult();
    }

    public List<Project> getSuccessResult() {
        return guestRepository.getSuccessResult();
    }

    public List<Project> getLongCompilation() {
        return guestRepository.getLongCompilation();
    }

    public List<Project> getNormalCompilation() {
        return guestRepository.getNormalCompilation();
    }


}
