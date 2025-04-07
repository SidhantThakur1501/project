package main.models;

public class Appliance extends Device {
    private String applianceType;
    private int energyStarRating;

    public Appliance(String id, String name, String location, double powerRating,
                    int quantity, String applianceType, int energyStarRating) {
        super(id, name, location, powerRating, quantity);
        this.applianceType = applianceType;
        this.energyStarRating = energyStarRating;
    }

    @Override
    public String getDeviceType() {
        return "Appliance";
    }

    // Additional getters
    public String getApplianceType() { return applianceType; }
    public int getEnergyStarRating() { return energyStarRating; }
}