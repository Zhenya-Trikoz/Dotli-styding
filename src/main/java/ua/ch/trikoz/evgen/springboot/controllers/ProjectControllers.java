package ua.ch.trikoz.evgen.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.ch.trikoz.evgen.springboot.model.Project;
import ua.ch.trikoz.evgen.springboot.server.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class ProjectControllers {

    @Autowired
    private ProjectService guestService;

    @GetMapping("/count")
    public int getCount() {
        return guestService.getCount();
    }

    @PutMapping("/register-compilation-time")
    public void register(@RequestParam String projectName, @RequestParam int compilationTime, @RequestParam String result) {
        guestService.register(projectName, compilationTime, result);
    }

    @GetMapping("/projects")
    public List<Project> getProjects() {
        return guestService.getProjects();
    }

    @GetMapping("/failed-results")
    public List<Project> getFailedResult() {
        return guestService.getFailedResult();
    }

    @GetMapping("/success-results")
    public List<Project> getSuccessResult() {
        return guestService.getSuccessResult();
    }

    @GetMapping("/long-compilation")
    public List<Project> getLongCompilation(){
        return guestService.getLongCompilation();
    }

    @GetMapping("/normal-compilation")
    public List<Project> getNormalCompilation(){
        return guestService.getNormalCompilation();
    }
}
