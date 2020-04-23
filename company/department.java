package company;

public class department {
    private String location;
    private String departmentName;
    private int departmentID;

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }

    ////
    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
    public int getDepartmentID() {
        return this.departmentID;
    }

    ////
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }

    public String toString(){
        return ("\nDepartment Name: " + getDepartmentName() + "\nDepartmentID: " + getDepartmentID() + "\nLocation: " + getLocation());
    }

}



