package lol;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender){
        setName(name);
        setEmail(email);
        setGender(gender);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    ////
    public void setGender(char gender){
        this.gender = gender;
    }
    public char getGender(){
        return this.gender;
    }

    ////
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }

    public String toString(){
        return ("Author Name: " + this.name + "\nE-Mail: " + this.email + "\nGender: " + this.gender + "\n");
    }

}
