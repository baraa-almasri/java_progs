package access_specifier_eg;
import java.util.Scanner;
public class Main {

        public static void main(String[] args){
            Scanner read = new Scanner(System.in);

            rectangle r1 = new rectangle();
            r1.setHeigth(read.nextDouble());
            r1.setWidth(read.nextDouble());
            r1.setColor(read.next());
            r1.print();

            circle c1 = new circle();
            c1.setRadius(read.nextDouble());
            c1.setCircumference(read.nextDouble());
            c1.setColor(read.next());
            c1.printArea();


        }

}



