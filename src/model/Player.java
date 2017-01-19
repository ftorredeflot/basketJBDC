package model;

/**
 *
 * @author ferran
 */

import java.time.LocalDate;

public class Player {
    private String name;
    private LocalDate born;
    private int nBaskets;
    private int nAssists;
    private int nRebots;
    private String pos;
    private Team team;

    public Player() {
    }

    public Player(String name, LocalDate born, int nBaskets, int nAssists, int nRebots, String pos, Team team) {
        this.name = name;
        this.born = born;
        this.nBaskets = nBaskets;
        this.nAssists = nAssists;
        this.nRebots = nRebots;
        this.pos = pos;
        this.team = team;
    }
    //getters
    public String getName() {
        return name;
    }

    public LocalDate getBorn() {
        return born;
    }

    public int getnBaskets() {
        return nBaskets;
    }

    public int getnAssists() {
        return nAssists;
    }

    public int getnRebots() {
        return nRebots;
    }

    public String getPos() {
        return pos;
    }

    public Team getTeam() {
        return team;
    }

    
    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBorn(LocalDate born) {
        this.born = born;
    }

    public void setnBaskets(int nBaskets) {
        this.nBaskets = nBaskets;
    }

    public void setnAssists(int nAssists) {
        this.nAssists = nAssists;
    }

    public void setnRebots(int nRebots) {
        this.nRebots = nRebots;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    
    
    
}