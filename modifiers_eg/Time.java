package Clock;

public class Time {
    //the private modifier allows access only in the same class
    //public modifier allows access from anywhere
    //default modifier allows access from in the same package only
    private int hours , minutes, seconds;

    //to use a private method or variable out side the class, use setters and getters

    //setter syntax
    public void setHours(int h){
        if ( h >=0 & h <= 23 ) {
            hours = h;
        }
        else hours = 0;
    }
    public void setMinutes(int m){
        if ( m >=0 & m <= 59 ) {
            minutes = m;
        }
        else minutes = 0;
    }
    public void setSeconds(int s){
        if ( s >=0 & s <= 59 ) {
            seconds = s;
        }
        else seconds = 0;
    }
    //note that in setters the first letter in the variable's name is upper case

    //getter syntax
    public int getHours(){
        return hours;
    }
    public int getMinutes(){
        return minutes;
    }
    public int getSeconds(){
        return seconds;
    }
    //note that in getters the first letter in the variable's name is upper case

}
