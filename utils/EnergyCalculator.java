package main.utils;

import main.models.EnergyPlan;

public class EnergyCalculator {
    public static double calculateDailyCost(double kWh, EnergyPlan plan) {
        return plan.calculateCost(kWh);
    }
    
    public static double convertWattsToKWH(double watts, double hours) {
        return (watts * hours) / 1000;
    }
}