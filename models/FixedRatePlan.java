package main.models;

public class FixedRatePlan implements EnergyPlan {
    private double ratePerKWh; // dollars per kWh

    public FixedRatePlan(double ratePerKWh) {
        this.ratePerKWh = ratePerKWh;
    }

    @Override
    public double calculateCost(double energyConsumption) {
        return energyConsumption * ratePerKWh;
    }

    @Override
    public String getPlanDetails() {
        return String.format("Fixed Rate: $%.3f per kWh", ratePerKWh);
    }

    // Add this getter method
    public double getRatePerKWh() {
        return ratePerKWh;
    }
}