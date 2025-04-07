package main.models;

public class TimeOfUsePlan implements EnergyPlan {
    private double peakRate;
    private double offPeakRate;
    private int peakStart;
    private int peakEnd;

    public TimeOfUsePlan(double peakRate, double offPeakRate, int peakStart, int peakEnd) {
        this.peakRate = peakRate;
        this.offPeakRate = offPeakRate;
        this.peakStart = peakStart;
        this.peakEnd = peakEnd;
    }

    @Override
    public double calculateCost(double energyConsumption) {
        // 40% peak usage, 60% off-peak
        return (energyConsumption * 0.4 * peakRate) + 
               (energyConsumption * 0.6 * offPeakRate);
    }

    @Override
    public String getPlanDetails() {
        return String.format("Time-of-Use (Peak %d:00-%d:00)", peakStart, peakEnd);
    }
}