package main.models;

public interface EnergyPlan {
    double calculateCost(double energyConsumption); // in kWh
    String getPlanDetails();
}