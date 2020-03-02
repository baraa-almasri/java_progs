import java.util.Scanner;
import java.lang.Math;
public class moo {

    public static void main(String[] args){
        //System.out.println("lol");
        Scanner mooscan = new Scanner(System.in);
        System.out.println("Enter two numbers:");
        double num = mooscan.nextDouble();
        double num2 = mooscan.nextDouble();

        System.out.println("Choose an operation:");
        System.out.println("1.+\t2.-\t3.*\t4./\t5.Power x^y\n6.sqrt(x)\t7.Log10(x)");//\t8.x!");
        int operation = mooscan.nextInt();

        switch(operation){
            case 1:
                System.out.println(num + num2);
                break;
            case 2:
                System.out.println(num - num2);
                break;
            case 3:
                System.out.println(num * num2);
                break;
            case 4:
                System.out.println(num / num2);
                break;
            case 5:
                System.out.println( Math.pow(num, num2) );
                break;
            case 6:
                System.out.println( Math.sqrt(num) );
                break;
            case 7:
                System.out.println( Math.log(num) );
                break;
            /*case 8:
                System.out.println( fact(num) );
                break;*/

        }
    }
}
