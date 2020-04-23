package company;

public class Employee extends Person {
    private int ID;
    private float salary;
    private boolean hasManager;
    private String ManagerName;
    private int departmentID;

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
    public float getSalary() {
        return this.salary;
    }

    ////
    public void setHasManager(String answer) {
        this.hasManager = (answer.equals("yes") || answer.equals("y") || answer.equals("Yes"));
    }
    public boolean getHasManager(){
        return this.hasManager;
    }
    ////
    public void setManagerName(String managerName) {
        this.ManagerName = managerName;
    }
    public String getManagerName() {
        return this.ManagerName;
    }

    ////
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
    public int getDepartmentID() {
        return this.departmentID;
    }

}
