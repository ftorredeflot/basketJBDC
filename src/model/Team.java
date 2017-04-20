package model;

/**
 *
 * @author ferran
 */

import java.time.LocalDate;


public class Team {

    private String name;
    private String location;
    private LocalDate fundation;

    public Team(String name, String location, LocalDate fundation) {
        this.name = name;
        this.location = location;
        this.fundation = fundation;
    }

    public Team() {
    }
//getters
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getFundation() {
        return fundation;
    }
    
    //setters

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFundation(LocalDate fundation) {
        this.fundation = fundation;
    }

    @Override
    public String toString() {
        return "Team{" + "name=" + name + ", location=" + location + ", fundation=" + fundation + '}';
    }
    
    


}