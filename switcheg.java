package lol;
import java.util.Scanner; 
class switcheg{
    
    public static void main (String[] args){
        
        int foo = 9 ;
        Scanner moo = new Scanner(System.in);
        
        System.out.println("Enter a mark");
        int mark = moo.nextInt();
        
        if ( mark > 100 | mark < 0 )
            return 0;
        
        switch (mark/10){
            case 10 :
            case 9 :
                System.out.println("A");
                break;
            case 8 :
                System.out.println("B");
                break;
            case 7 :
                System.out.println("C");
                break;
            case 6 :
                System.out.println("D");
                break;
            case 5 :
                System.out.println("E");
                break;
            default :
                System.out.println("F");
                break;
            
                
        }
       
        
        
        
    }
    
}