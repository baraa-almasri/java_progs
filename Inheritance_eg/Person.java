package Inheritance_eg;

abstract class Person {
    private String FName;
    private String LName;
    private int phoneNumber;
    private String address;
    private String nationality;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    ////
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getNationality() {
        return nationality;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }
    public String getFName() {
        return FName;
    }
    ////

    public void setLName(String LName) {
        this.LName = LName;
    }
    public String getLName() {
        return LName;
    }

    ////
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }

    ////
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public String toString(){
        return ("\nFull Name: " + getFName() +" "+ getLName() +"\nPhone NUmber: "+getPhoneNumber() +"\nAddress: " + getAddress() );
    }
}
