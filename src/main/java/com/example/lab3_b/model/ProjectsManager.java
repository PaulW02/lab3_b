package com.example.lab3_b.model;

import com.example.lab3_b.model.exceptions.TitleNotUniqueException;

import java.util.ArrayList;
import java.util.List;

public class ProjectsManager {
    private int nextProjectId;
    private final ArrayList<Project> projects;

    public ProjectsManager() {
        this.projects = new ArrayList<>();
        this.nextProjectId = 0;
    }

    /** Clears the projects and sets the list with the incoming projects.
     * @param incomingProjects a list of incoming projects that is added to the projects.
     */
    public void setProjects(List<Project> incomingProjects){
        projects.clear();
        projects.addAll(incomingProjects);
        nextProjectId = projects.size();
    }


    /** Return a list of the projects
     * @return a copy of the list of projects
     */
    public List<Project> getProjects() {
        List<Project> projectsToReturn = (List<Project>) projects.clone();
        return projectsToReturn;
    }


    /** Compares the specific title to the titles of all projects and returns true if any titles equals eachother.
     * @param title the title of a project to be compared with.
     * @return whether the title equals to any of the titles among the projects.
     */
    public boolean isTitleUnique(String title){
        for (Project p: projects) {
            if(p.getTitle().equals(title)){
                return false;
            }
        }
        return true;
    }


    /** Adds a new project if the new title is unique.
     * @param title the title of the new project.
     * @param description the description of the new project.
     * @return the new project that has been added.
     * @throws TitleNotUniqueException if the title of the new project equals an existing one.
     */
    public Project addProject(String title, String description) throws TitleNotUniqueException {
        if(isTitleUnique(title)) {
            Project newProject = new Project(title, nextProjectId, description);
            projects.add(newProject);
            nextProjectId = projects.size();
            return newProject;
        }else {
            throw new TitleNotUniqueException();
        }
    }


    /** Removes a specific project from the list of projects
     * @param project the project to be removed
     */
    public void removeProject(Project project){
        projects.remove(project);
    }


    /** Return a project from a specific id.
     * @param id the project's id.
     * @return the project specified by the id.
     */
    public Project getProjectById(int id){
        return projects.get(id);
    }


    /** Return the projects that have a title that contains the titleStr.
     * @param titleStr a title-string to match with the project titles.
     * @return the projects with titles that contains titleStr.
     */
    public List<Project> findProjects(String titleStr){
        List<Project> foundProjects = new ArrayList<>();
        for (Project p: projects) {
            if(p.getTitle().contains(titleStr)){
                foundProjects.add(p);
            }
        }
        return foundProjects;
    }


    /** Return the highest id of the projects
     * @return the highest id
     */
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
