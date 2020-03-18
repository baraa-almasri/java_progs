package moo.demo.main;
import moo.demo.Data.Data;
import java.util.Scanner;
public class main{
    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int counter = 1;
        Data student;
        student = new Data();
        do{
            System.out.print("Enter Student #" + counter + " name: ");
            student.name = read.next();

            System.out.print("Enter Student #" + counter + " GPA: ");
            student.gpa = read.nextDouble();

            System.out.print("Enter Student #" + counter + " ID: ");
            student.ID = read.nextInt();

            student.list();

            System.out.print("1.Exit , 2.Enter Another Student's Data ? ");
            int proc = read.nextInt();
            if (proc == 1) break;

            counter++;
        }while(true);
    }
}
