package main.models;

public abstract class Device {
    private String id;
    private String name;
    private String location;
    private double powerRating; // in watts
    private int quantity;
    private double dailyUsageHours; // in hours

    public Device(String id, String name, String location, double powerRating, int quantity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.powerRating = powerRating;
        this.quantity = quantity;
        this.dailyUsageHours = 0;
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public double getPowerRating() { return powerRating; }
    public int getQuantity() { return quantity; }
    public double getDailyUsageHours() { return dailyUsageHours; }
    public void setDailyUsageHours(double hours) { this.dailyUsageHours = hours; }

    public abstract String getDeviceType();

    public double calculateDailyConsumption() {
        return (powerRating * quantity * dailyUsageHours) / 1000; // Returns kWh
    }
}