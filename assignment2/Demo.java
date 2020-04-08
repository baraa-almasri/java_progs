package assignment2;

public class Demo {
    public static void main(String[] k){

        SavingAccount saving1,saving2;

        saving1 = new SavingAccount(2000);
        SavingAccount.modifyIntrestRate(4);
        saving1.calculateMonthlyIntrests();
        System.out.printf("%f\n", saving1.getSavingsBalance() );
        SavingAccount.modifyIntrestRate(5);
        saving1.calculateMonthlyIntrests();
        System.out.printf("%f\n", saving1.getSavingsBalance() );

        System.out.printf("\n");

        saving2 = new SavingAccount(3000);
        SavingAccount.modifyIntrestRate(4);
        saving2.calculateMonthlyIntrests();
        System.out.printf("%f\n", saving2.getSavingsBalance() );
        SavingAccount.modifyIntrestRate(5);
        saving2.calculateMonthlyIntrests();
        System.out.printf("%f\n", saving2.getSavingsBalance() );




    }
}
