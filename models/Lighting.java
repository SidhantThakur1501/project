package main.models;

public class Lighting extends Device {
    private String lightingType; // LED, CFL, etc.
    private int brightness; // 0-100%

    public Lighting(String id, String name, String location, double powerRating,
                   int quantity, String lightingType) {
        super(id, name, location, powerRating, quantity);
        this.lightingType = lightingType;
        this.brightness = 100; // Default to full brightness
    }

    @Override
    public String getDeviceType() {
        return "Lighting";
    }

    // Additional methods
    public void setBrightness(int level) {
        this.brightness = Math.max(0, Math.min(100, level));
    }

    public int getBrightness() { return brightness; }
    public String getLightingType() { return lightingType; }
}