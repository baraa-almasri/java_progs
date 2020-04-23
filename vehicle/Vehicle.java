package vehicle;

abstract class Vehicle {
    private String engineName;
    private String fuelType;
    private String color;
    private String manufacturer;
    private String model;
    private int numberOfPasengers;

    ////
    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }
    public String getEngineName() {
        return this.engineName;
    }

    ////
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
    public String getFuelType() {
        return this.fuelType;
    }

    ////
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return this.color;
    }

    ////
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getManufacturer() {
        return this.manufacturer;
    }

    ////
    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return this.model;
    }

    /////
    public void setNumberOfPasengers(int numberOfPasengers) {
        this.numberOfPasengers = numberOfPasengers;
    }
    public int getNumberOfPasengers() {
        return this.numberOfPasengers;
    }

}
