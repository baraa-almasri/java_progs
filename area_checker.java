import java.util.Scanner;
public class area_checker {
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        double h,w;
        System.out.println("Enter two values");
        while(true){
            h = read.nextDouble();
            w = read.nextDouble();
            if ( h * w < 0 ) {
                System.out.println("You've entered a negative value re-enter!");
                continue;
            }
            else {
                System.out.println(h*w);
                break;
            }
        }


    }
}
