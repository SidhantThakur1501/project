package main.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyEnergyReport extends EnergyReport {
    private double totalConsumption;
    private double peakConsumption;
    private double estimatedCost;
    private String details;

    public DailyEnergyReport(String reportId) {
        super(reportId, "Daily");
    }

    @Override
    public void generateReport(Building building) {
        this.totalConsumption = building.calculateTotalDailyConsumption();
        this.peakConsumption = totalConsumption * 0.3;
        
        String date = new SimpleDateFormat("EEE, MMM d yyyy").format(new Date());
        String time = new SimpleDateFormat("HH:mm:ss").format(getGeneratedDate());
        
        this.details = String.format(
            "DAILY ENERGY REPORT\n" +
            "================================\n" +
            "Date: %s at %s\n\n" +
            "Total Consumption: %.2f kWh\n" +
            "Peak Consumption:  %.2f kWh\n" +
            "Avg. Power Demand: %.2f kW\n" +
            "Estimated Cost:    $%.2f\n" +
            "================================\n",
            date, time,
            totalConsumption,
            peakConsumption,
            (totalConsumption * 1000) / 24,
            estimatedCost
        );
    }

    public void setEstimatedCost(double ratePerKWh) {
        this.estimatedCost = totalConsumption * ratePerKWh;
        // Update the details string with the new cost
        updateDetailsWithCost();
    }

    private void updateDetailsWithCost() {
        // Rebuild the details string with the current cost
        String date = new SimpleDateFormat("EEE, MMM d yyyy").format(new Date());
        String time = new SimpleDateFormat("HH:mm:ss").format(getGeneratedDate());
        
        this.details = String.format(
            "DAILY ENERGY REPORT\n" +
            "================================\n" +
            "Date: %s at %s\n\n" +
            "Total Consumption: %.2f kWh\n" +
            "Peak Consumption:  %.2f kWh\n" +
            "Avg. Power Demand: %.2f kW\n" +
            "Estimated Cost:    $%.2f\n" +
            "================================\n",
            date, time,
            totalConsumption,
            peakConsumption,
            (totalConsumption * 1000) / 24,
            estimatedCost
        );
    }

    @Override
    public String getReportContent() {
        return details;
    }

    public double getTotalConsumption() {
        return totalConsumption;
    }

    public double getPeakConsumption() {
        return peakConsumption;
    }
}