package lol;

import java.util.Scanner; 
public class LOL {


    public static void main(String[] args) {

        int foo = 9 ;
        Scanner moo = new Scanner(System.in);
        int mark = moo.nextInt();
        
        if ( mark >= 90 & mark <= 100 )
            System.out.println("A");
        else if ( mark < 90 & mark >= 80 )
            System.out.println("B");
        else if ( mark >= 70 & mark < 80 )
            System.out.println("C");
        else if ( mark < 70 & mark >= 60  )
            System.out.println("D");
        else if ( mark >= 50 & mark < 60 )
            System.out.println("E");
        else if ( mark < 50 )
            System.out.println("F");
        
        if ( mark > 100 | mark < 0 )
            return 0;
        

    }
    
}
