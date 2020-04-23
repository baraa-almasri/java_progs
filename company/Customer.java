package company;

public class Customer extends Person {
    private int NoOfVisits;
    private int debts;


    public void setNoOfVisits(int noOfVisits) {
        this.NoOfVisits = noOfVisits;
    }
    public int getNoOfVisits() {
        return this.NoOfVisits;
    }
    ////

    public void setDebts(int debts) {
        this.debts = debts;
    }
    public int getDebts() {
        return this.debts;
    }



}
