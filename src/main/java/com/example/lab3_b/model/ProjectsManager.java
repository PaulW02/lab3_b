package com.example.lab3_b.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectsManager {
    private int nextProjectId;
    private List<Project> projects;

    public ProjectsManager() {
        this.projects = new ArrayList<>();
    }

    public void setProjects(List<Project> incomingProjects){
        projects.addAll(incomingProjects);
    }

    public List<Project> getProjects() {
        return projects;
    }

    public boolean isTitleUnique(String title){
        return false;
    }

    public Project addProject(String title, String description){
        Project newProject = new Project(title, nextProjectId, description);
        projects.add(newProject);
        return newProject;
    }

    public void removeProject(Project project){
        projects.remove(project);
    }

    public Project getProjectById(int id){
        return projects.get(id);
    }

    public List<Project> findProjects(String titleStr){
        return projects;
    }

    private int getHighestId(){
        return 0;
    }
}
