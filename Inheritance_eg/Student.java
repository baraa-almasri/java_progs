package Inheritance_eg;

public class Student extends Person {
    private String studyLevel;
    private String major;
    private double gpa;

    public void setStudyLevel(String studyLevel) {
        this.studyLevel = studyLevel;
    }
    public String getStudyLevel() {
        return studyLevel;
    }

    ////
    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }


    ////
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public double getGpa() {
        return gpa;
    }
}
