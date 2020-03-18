package Clock;
import java.util.Scanner;
public class demo {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);

        //instanciating objects
        Time t1 = new Time();
        Time t2 = new Time();

        //using setters to modify object's instances
        t1.setHours( read.nextInt() );
        t1.setMinutes( read.nextInt() );
        t1.setSeconds( read.nextInt() );

        //using getters to access object's instances
        System.out.println( t1.getHours() + ":" + t1.getMinutes() + ":" + t1.getSeconds() );

        //same here
        t2.setHours( read.nextInt() );
        t2.setMinutes( read.nextInt() );
        t2.setSeconds( read.nextInt() );

        System.out.println( t2.getHours() + ":" + t2.getMinutes() + ":" + t2.getSeconds() );


    }
}
