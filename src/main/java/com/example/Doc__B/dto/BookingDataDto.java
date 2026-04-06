package com.example.Doc__B.dto;

import java.util.List;

public class BookingDataDto {
    private String id;
    private String name;
    private String phone;
    private String email;
    private Boolean isNewPatient;
    private String insurance;
    private List<String> chronicConditions;
    private List<String> allergies;
    private String type;
    private String specialty;
    private String date;
    private String time;
    private String reason;
    private String status;
    private String token;
    private String roomAssigned;
    private String telehealthLink;
    private String doctorAssigned;
    private String doctorNotes;
    private List<String> labRequests;
    private Boolean followUpGenerated;
    private VitalsDto vitals;
    private List<PrescriptionDto> prescriptions;

    public BookingDataDto() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getIsNewPatient() { return isNewPatient; }
    public void setIsNewPatient(Boolean isNewPatient) { this.isNewPatient = isNewPatient; }
    public String getInsurance() { return insurance; }
    public void setInsurance(String insurance) { this.insurance = insurance; }
    public List<String> getChronicConditions() { return chronicConditions; }
    public void setChronicConditions(List<String> chronicConditions) { this.chronicConditions = chronicConditions; }
    public List<String> getAllergies() { return allergies; }
    public void setAllergies(List<String> allergies) { this.allergies = allergies; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }
    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }
    public String getRoomAssigned() { return roomAssigned; }
    public void setRoomAssigned(String roomAssigned) { this.roomAssigned = roomAssigned; }
    public String getTelehealthLink() { return telehealthLink; }
    public void setTelehealthLink(String telehealthLink) { this.telehealthLink = telehealthLink; }
    public String getDoctorAssigned() { return doctorAssigned; }
    public void setDoctorAssigned(String doctorAssigned) { this.doctorAssigned = doctorAssigned; }
    public String getDoctorNotes() { return doctorNotes; }
    public void setDoctorNotes(String doctorNotes) { this.doctorNotes = doctorNotes; }
    public List<String> getLabRequests() { return labRequests; }
    public void setLabRequests(List<String> labRequests) { this.labRequests = labRequests; }
    public Boolean getFollowUpGenerated() { return followUpGenerated; }
    public void setFollowUpGenerated(Boolean followUpGenerated) { this.followUpGenerated = followUpGenerated; }
    public VitalsDto getVitals() { return vitals; }
    public void setVitals(VitalsDto vitals) { this.vitals = vitals; }
    public List<PrescriptionDto> getPrescriptions() { return prescriptions; }
    public void setPrescriptions(List<PrescriptionDto> prescriptions) { this.prescriptions = prescriptions; }
}
