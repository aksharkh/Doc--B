package com.example.Doc__B.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id")
    private Patient patient;

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

    @Column(columnDefinition = "TEXT")
    private String doctorNotes;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "booking_lab_requests", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "lab_request")
    private List<String> labRequests;

    private Boolean followUpGenerated;

    @Embedded
    private Vitals vitals;

    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Prescription> prescriptions;

    public Booking() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
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
    public Vitals getVitals() { return vitals; }
    public void setVitals(Vitals vitals) { this.vitals = vitals; }
    public List<Prescription> getPrescriptions() { return prescriptions; }
    public void setPrescriptions(List<Prescription> prescriptions) { this.prescriptions = prescriptions; }
}
