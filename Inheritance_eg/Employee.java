package Inheritance_eg;

public class Employee extends Person {
    private int ID;
    private double salary;
    private String rank;
    private String position;

    ////
    public void setPosition(String position) {
        this.position = position;
    }
    public String getPosition() {
        return position;
    }

    ////
    public void setRank(String rank) {
        this.rank = rank;
    }
    public String getRank() {
        return rank;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public int getID() {
        return this.ID;
    }

    ////
    public void setSalary(float salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return this.salary;
    }

    ////


}
