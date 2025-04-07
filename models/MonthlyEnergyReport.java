package main.models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MonthlyEnergyReport extends EnergyReport {
    private double totalConsumption;
    private double averageDaily;
    private double estimatedCost;
    private String details;

    public MonthlyEnergyReport(String reportId) {
        super(reportId, "Monthly");
    }

    @Override
    public void generateReport(Building building) {
        // Calculate based on ACTUAL building data (not random)
        this.totalConsumption = building.calculateTotalDailyConsumption() * 30; // 30 days
        this.averageDaily = totalConsumption / 30;
        
        // Format report with consistent values
        String period = new SimpleDateFormat("MMM yyyy").format(getGeneratedDate());
        
        this.details = String.format(
            "MONTHLY ENERGY REPORT\n" +
            "================================\n" +
            "Period: %s\n\n" +
            "Total Consumption: %.2f kWh\n" +
            "Daily Average:     %.2f kWh\n" +
            "================================\n",
            period,
            totalConsumption,
            averageDaily
        );
    }

    @Override
    public String getReportContent() {
        return details;
    }

    // For cost calculation (used by AnalyticsService)
    public void setEstimatedCost(double ratePerKWh) {
        this.estimatedCost = totalConsumption * ratePerKWh;
        this.details = this.details.replace("================================\n",
            String.format("Estimated Cost:    $%.2f\n================================\n", estimatedCost));
    }
}