package assignment2;

public class SavingAccount {
    private static int annualIntrestsRate;
    private double savingsBalance;

    public SavingAccount(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void calculateMonthlyIntrests(){
        this.savingsBalance += (savingsBalance*annualIntrestsRate)/12;
    }

    static void modifyIntrestRate(int newValue){
        annualIntrestsRate = newValue;
    }

}
