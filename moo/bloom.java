package moo;
import java.lang.Math;

public class bloom {
    public static void main(String[] args){
        Point p1;
        p1 = new Point();
        p1.x = 4;
        p1.y = 6;

        Point p2 = new Point();
        p2.x = 5;
        p2.y = 66;

        p1.print();
        p2.print();
        //calculating the distance
        double dist1 = Math.sqrt( Math.pow( ( p2.x - p1.x) , 2 ) + Math.pow( ( p2.y - p1.y) , 2 ) );
        System.out.println("Distance between p1 & p2" + dist1);
    }
}
