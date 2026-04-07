package com.example.Doc__B.dto;

import java.util.Map;

public class AnalyticsDto {
    private long totalBookings;
    private long activePatients;
    private long activeSessions;
    private Map<String, Long> volumeByDay;
    private Map<String, Long> volumeByMonth;
    private Map<String, Long> volumeByYear;
    private Map<String, Long> specialtyDistribution;

    public AnalyticsDto() {}

    public long getTotalBookings() { return totalBookings; }
    public void setTotalBookings(long totalBookings) { this.totalBookings = totalBookings; }
    public long getActivePatients() { return activePatients; }
    public void setActivePatients(long activePatients) { this.activePatients = activePatients; }
    public long getActiveSessions() { return activeSessions; }
    public void setActiveSessions(long activeSessions) { this.activeSessions = activeSessions; }
    public Map<String, Long> getVolumeByDay() { return volumeByDay; }
    public void setVolumeByDay(Map<String, Long> volumeByDay) { this.volumeByDay = volumeByDay; }
    public Map<String, Long> getVolumeByMonth() { return volumeByMonth; }
    public void setVolumeByMonth(Map<String, Long> volumeByMonth) { this.volumeByMonth = volumeByMonth; }
    public Map<String, Long> getVolumeByYear() { return volumeByYear; }
    public void setVolumeByYear(Map<String, Long> volumeByYear) { this.volumeByYear = volumeByYear; }
    public Map<String, Long> getSpecialtyDistribution() { return specialtyDistribution; }
    public void setSpecialtyDistribution(Map<String, Long> specialtyDistribution) { this.specialtyDistribution = specialtyDistribution; }
}
