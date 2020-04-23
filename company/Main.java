package company;

import java.util.Scanner;
public class Main{

    public static void main(String[] args){
        Scanner read = new Scanner(System.in);
        int numberOfEmployees = 1;
        Employee[] employees = new Employee[numberOfEmployees];
        
        for(int emp = 0 ; emp < numberOfEmployees ; emp++ ){
            employees[emp] = new Employee();
            System.out.printf("Enter Employee #%d First Name: ",(emp+1));
            employees[emp].setFName(read.next());

            System.out.printf("Enter Employee #%d Last Name: ",(emp+1));
            employees[emp].setLName(read.next());

            System.out.printf("Enter Employee #%d PhoneNumber: ",(emp+1));
            employees[emp].setPhoneNumber(read.nextInt());

            System.out.printf("Enter Employee #%d Address: ",(emp+1));
            employees[emp].setAddress(read.next());

            System.out.printf("Enter Employee #%d ID: ",(emp+1));
            employees[emp].setID(read.nextInt());

            System.out.printf("Does Employee #%d has a manager [y|n] ",(emp+1));
            employees[emp].setHasManager(read.next());

            System.out.printf("Enter Employee #%d Salary: ",(emp+1));
            employees[emp].setSalary(read.nextFloat());

            System.out.printf("Enter Employee #%d Department ID: ",(emp+1));
            employees[emp].setDepartmentID(read.nextInt());

            if(employees[emp].getHasManager()) {
                System.out.printf("Enter Employee #%d manager's name: ", (emp + 1));
                employees[emp].setManagerName(read.next());
            }

        }

        for(int emp = 0 ; emp < numberOfEmployees ; emp++ ){
            System.out.printf("%s\n",employees[emp]);
            System.out.printf("%d\n",employees[emp].getID());
            System.out.printf("%f\n",employees[emp].getSalary());
            System.out.printf("%d\n",employees[emp].getDepartmentID());
            if(employees[emp].getHasManager())
                System.out.printf("%s\n",employees[emp].getManagerName());

        }

        int numberOfDeparments = 1;
        department[] Departments = new department[numberOfDeparments];


        for(int index = 0 ; index < numberOfDeparments ; index++ ){
            Departments[index] = new department();
            System.out.printf("Enter department #%d Location: ", index+1);
            Departments[index].setLocation(read.next());

            employees[index] = new Employee();
            System.out.printf("Enter department #%d Name: ", index+1);
            Departments[index].setDepartmentName(read.next());

            employees[index] = new Employee();
            System.out.printf("Enter department #%d ID: ", index+1);
            Departments[index].setDepartmentID(read.nextInt());

        }

        System.out.printf("%d\n",employees[0].getDepartmentID());

        for(int index = 0 ; index < numberOfDeparments ; index++ ) {
            System.out.printf("%s", Departments[index]);

            System.out.printf("\nEmployees @ department %s", Departments[index].getDepartmentName());
            for (int emp = 0; emp < numberOfEmployees; emp++) {

                if (employees[emp].getDepartmentID() == Departments[index].getDepartmentID()) {
                    System.out.printf("%s", employees[emp]);
                }
            }
        }

    }
}

