package main.java.com.company;

import java.util.ArrayList;

public class Project {


    /**
     * Class Project
     * @author Anbang
     */


    String organization;
    String name;
    int starGazer;
    int forks;
    ArrayList<String> mainContributors;


    /**
     * Constructor
     * @param organization
     * @param name
     * @param starGazer
     * @param forks
     * @param mainContributors
     * @author Anbang
     */

    public Project(String organization, String name, int starGazer, int forks, ArrayList<String> mainContributors) {
        this.organization = organization;
        this.name = name;
        this.starGazer = starGazer;
        this.forks = forks;
        this.mainContributors = mainContributors;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStarGazer() {
        return starGazer;
    }

    public void setStarGazer(int starGazer) {
        this.starGazer = starGazer;
    }

    public int getForks() {
        return forks;
    }

    public void setForks(int forks) {
        this.forks = forks;
    }

    public ArrayList<String> getMainContributors() {
        return mainContributors;
    }

    public void setMainContributors(ArrayList<String> mainContributors) {
        this.mainContributors = mainContributors;
    }
}
