package object_eg;
import java.lang.Math;
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        System.out.println("Enter cords of p1: ");
        Point p1;
        p1 = new Point();
        p1.x = read.nextInt();
        p1.y = read.nextInt();

        System.out.println("Enter cords of p2: ");
        Point p2 = new Point();
        p2.x = read.nextInt();
        p2.y = read.nextInt();

        p1.print();
        p2.print();
        //calculating the distances
        double dist1 = Math.sqrt( Math.pow( ( p2.x - p1.x) , 2 ) + Math.pow( ( p2.y - p1.y) , 2 ) );
        double dist2 = Math.sqrt( Math.pow( ( p2.x) , 2 ) + Math.pow( ( p2.y) , 2 ) );
        double dist3 = Math.sqrt( Math.pow( ( p1.x) , 2 ) + Math.pow( ( p1.y) , 2 ) );

        System.out.println("Distance between p1 & p2 " + dist1);
        System.out.println("Distance between p2 & the origin " + dist2);
        System.out.println("Distance between p1 & the origin " + dist3);
        System.out.println();

        //3D point
        System.out.println("Enter cords of p3(3D): ");
        Point3D p3 = new Point3D();
        p3.x = read.nextInt();
        p3.y = read.nextInt();
        p3.z = read.nextInt();

        System.out.println("Enter cords of p4(3D): ");
        Point3D p4 = new Point3D();
        p4.x = read.nextInt();
        p4.y = read.nextInt();
        p4.z = read.nextInt();
        //calculating the distances
        p4.print();
        p4.print();
        double dist4 = Math.sqrt( Math.pow( ( p3.x) , 2 ) + Math.pow( ( p3.y) , 2 ) + Math.pow( ( p3.z) , 2 ) );
        double dist5 = Math.sqrt( Math.pow( ( p4.x) , 2 ) + Math.pow( ( p4.y) , 2 ) + Math.pow( ( p4.z) , 2 ) );
        double dist6 = Math.sqrt( Math.pow( ( p4.x - p3.x) , 2 ) + Math.pow( ( p4.y - p3.y) , 2 ) + Math.pow( ( p4.z - p3.z) , 2 ) );

        System.out.println("Distance between p3 & the origin " + dist4);
        System.out.println("Distance between p4 & the origin " + dist5);
        System.out.println("Distance between p3 & p4 " + dist6);


    }
}
