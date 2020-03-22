package access_specifier_eg;
public class rectangle {
    private double higth , width;
    private String color;
    //contructor
    public rectangle(){
        higth = width = 1;
        color = "Green";
    }
    public void setWidth(double width){
        if(width < 0) width*=-1;
        this.width = width;
        //"this" is used to access the main variable width
    }
    public double getWidth(){
        return width;
    }
    public void setHeigth(double higth){
        if(higth < 0) higth*=-1;
        this.higth = higth;
        //"this" is used to access the main variable width
    }
    public double getHigth(){
        return higth;
    }
    public void setColor(String color){
        this.color = color;
        //"this" is used to access the main variable width
    }

    public String getColor(){
        return color;
    }

    public void print(){
        System.out.println("Higth: " + higth + "\nWidth: " + width + "\nColor: "+color );
    }
}
