package assignment2;

public class SavingAccount {
    static int annualIntrestsRate;
    private double savingBalance;

    public SavingAccount(double savingBalance){
        this.savingBalance = savingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public double calculateMonthlyIntrests(){
        return (savingBalance*annualIntrestsRate)/12;
    }

    static void modifyIntrestRate(int newValue){
        annualIntrestsRate = newValue;
    }

}
