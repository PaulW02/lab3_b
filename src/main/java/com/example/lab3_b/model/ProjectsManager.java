package com.example.lab3_b.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectsManager {
    private int nextProjectId;
    private final ArrayList<Project> projects;

    public ProjectsManager() {
        this.projects = new ArrayList<>();
        this.nextProjectId = 0;
    }

    public void setProjects(List<Project> incomingProjects){
        projects.clear();
        projects.addAll(incomingProjects);
        nextProjectId = projects.size();
    }

    public List<Project> getProjects() {
        List<Project> projectsToReturn = (List<Project>) projects.clone();
        return projectsToReturn;
    }

    public boolean isTitleUnique(String title){
        for (Project p: projects) {
            if(p.getTitle().equals(title)){
                return false;
            }
        }
        return true;
    }

    public Project addProject(String title, String description) throws TitleNotUniqueException{
        if(isTitleUnique(title)) {
            Project newProject = new Project(title, nextProjectId, description);
            projects.add(newProject);
            nextProjectId = projects.size();
            return newProject;
        }else {
            throw new TitleNotUniqueException();
        }
    }

    public void removeProject(Project project){
        projects.remove(project);
    }

    public Project getProjectById(int id){
        return projects.get(id);
    }

    public List<Project> findProjects(String titleStr){
        List<Project> foundProjects = new ArrayList<>();
        for (Project p: projects) {
            if(p.getTitle().equals(titleStr)){
                foundProjects.add(p);
            }
        }
        return foundProjects;
    }

    private int getHighestId(){
        return nextProjectId-1;
    }

    @Override
    public String toString() {
        return "ProjectsManager{" +
                "projects=" + projects +
                '}';
    }
}
