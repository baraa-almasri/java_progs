package assignment2;

public class Demo {
    public static void main(String[] k){

        SavingAccount saving1,saving2;

        saving1 = new SavingAccount(2000);
        SavingAccount.modifyIntrestRate(4);
        System.out.printf("%f\n", saving1.calculateMonthlyIntrests() );
        SavingAccount.modifyIntrestRate(5);
        System.out.printf("%f\n\n", saving1.calculateMonthlyIntrests() );

        saving2 = new SavingAccount(3000);
        SavingAccount.modifyIntrestRate(4);
        System.out.printf("%f\n", saving2.calculateMonthlyIntrests() );
        SavingAccount.modifyIntrestRate(5);
        System.out.printf("%f\n", saving2.calculateMonthlyIntrests() );



    }
}
