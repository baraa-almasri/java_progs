package access_specifier_eg;
import java.lang.Math;
public class circle {
    private double circumference , radius;
    private String color;

    public void setCircumference(double circumference){
        if(circumference < 0) circumference*=-1;
        this.circumference = circumference;
    }
    public double getCircumference(){
        return circumference;
    }
    public void setRadius(double radius){
        if(radius < 0) radius*=-1;
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }


    public void printArea(){
        System.out.println("Circumference: " + circumference + "\nRadius: " + radius + "\nColor: "+color + "\nArea: " + (Math.pow(radius,2)*Math.PI));
    }
}
