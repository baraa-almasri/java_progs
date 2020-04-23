package vehicle;

public class Bus extends Vehicle{
    private String doorOpenButtonType;
    private int noOfShelves;

    public void setDoorOpenButtonType(String doorOpenButton) {
        this.doorOpenButtonType = doorOpenButton;
    }
    public String getDoorOpenButtonType(){
        return this.doorOpenButtonType;
    }

    ////
    public void setNoOfShelves(int noOfShelves) {
        this.noOfShelves = noOfShelves;
    }
    public int getNoOfShelves() {
        return noOfShelves;
    }
}
