package main.models;

import java.util.Date;

public abstract class EnergyReport {
    protected String reportId;
    protected Date generatedDate;
    protected String reportType;

    public EnergyReport(String reportId, String reportType) {
        this.reportId = reportId;
        this.generatedDate = new Date();
        this.reportType = reportType;
    }

    public abstract void generateReport(Building building);
    public abstract String getReportContent();

    // Getters
    public String getReportId() { return reportId; }
    public Date getGeneratedDate() { return generatedDate; }
    public String getReportType() { return reportType; }
}


