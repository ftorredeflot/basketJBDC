package model;

public class Stats {
    private String position;
    private Team team;
    private double avgB;
    private double avgA;
    private double avgR;
    private int maxB;
    private int maxA;
    private int maxR;
    private int minB;
    private int minA;
    private int minR;

    public Stats(String position, double avgB, double avgA, double avgR, int maxB, int maxA, int maxR, int minB, int minA, int minR) {
        this.position = position;
        this.avgB = avgB;
        this.avgA = avgA;
        this.avgR = avgR;
        this.maxB = maxB;
        this.maxA = maxA;
        this.maxR = maxR;
        this.minB = minB;
        this.minA = minA;
        this.minR = minR;
    }
    
    public Stats() {
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public double getAvgB() {
        return avgB;
    }

    public void setAvgB(double avgB) {
        this.avgB = avgB;
    }

    public double getAvgA() {
        return avgA;
    }

    public void setAvgA(double avgA) {
        this.avgA = avgA;
    }

    public double getAvgR() {
        return avgR;
    }

    public void setAvgR(double avgR) {
        this.avgR = avgR;
    }

    public int getMaxB() {
        return maxB;
    }

    public void setMaxB(int maxB) {
        this.maxB = maxB;
    }

    public int getMaxA() {
        return maxA;
    }

    public void setMaxA(int maxA) {
        this.maxA = maxA;
    }

    public int getMaxR() {
        return maxR;
    }

    public void setMaxR(int maxR) {
        this.maxR = maxR;
    }

    public int getMinB() {
        return minB;
    }

    public void setMinB(int minB) {
        this.minB = minB;
    }

    public int getMinA() {
        return minA;
    }

    public void setMinA(int minA) {
        this.minA = minA;
    }

    public int getMinR() {
        return minR;
    }

    public void setMinR(int minR) {
        this.minR = minR;
    }

    @Override
    public String toString() {
        return "Stats{" + "position=" + position + ", avgB=" + avgB + ", avgA=" + avgA + ", avgR=" + avgR + ", maxB=" + maxB + ", maxA=" + maxA + ", maxR=" + maxR + ", minB=" + minB + ", minA=" + minA + ", minR=" + minR + '}';
    }
    
    
}