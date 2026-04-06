package com.example.Doc__B.service.impl;

import com.example.Doc__B.dto.BookingDataDto;
import com.example.Doc__B.dto.PrescriptionDto;
import com.example.Doc__B.dto.VitalsDto;
import com.example.Doc__B.entity.Booking;
import com.example.Doc__B.entity.Patient;
import com.example.Doc__B.entity.Prescription;
import com.example.Doc__B.entity.Vitals;
import com.example.Doc__B.exception.ResourceNotFoundException;
import com.example.Doc__B.repository.BookingRepository;
import com.example.Doc__B.repository.PatientRepository;
import com.example.Doc__B.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final PatientRepository patientRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, PatientRepository patientRepository) {
        this.bookingRepository = bookingRepository;
        this.patientRepository = patientRepository;
    }

    private BookingDataDto mapToDto(Booking booking) {
        BookingDataDto dto = new BookingDataDto();
        dto.setId(booking.getId());
        dto.setType(booking.getType());
        dto.setSpecialty(booking.getSpecialty());
        dto.setDate(booking.getDate());
        dto.setTime(booking.getTime());
        dto.setReason(booking.getReason());
        dto.setStatus(booking.getStatus());
        dto.setToken(booking.getToken());
        dto.setRoomAssigned(booking.getRoomAssigned());
        dto.setTelehealthLink(booking.getTelehealthLink());
        dto.setDoctorAssigned(booking.getDoctorAssigned());
        dto.setDoctorNotes(booking.getDoctorNotes());
        dto.setLabRequests(booking.getLabRequests());
        dto.setFollowUpGenerated(booking.getFollowUpGenerated());

        if (booking.getPatient() != null) {
            dto.setName(booking.getPatient().getName());
            dto.setPhone(booking.getPatient().getPhone());
            dto.setEmail(booking.getPatient().getEmail());
            dto.setIsNewPatient(booking.getPatient().getIsNewPatient());
            dto.setInsurance(booking.getPatient().getInsurance());
            dto.setChronicConditions(booking.getPatient().getChronicConditions());
            dto.setAllergies(booking.getPatient().getAllergies());
        }

        if (booking.getVitals() != null) {
            VitalsDto vDto = new VitalsDto();
            vDto.setBp(booking.getVitals().getBp());
            vDto.setHr(booking.getVitals().getHr());
            vDto.setTemp(booking.getVitals().getTemp());
            vDto.setWeight(booking.getVitals().getWeight());
            dto.setVitals(vDto);
        }

        if (booking.getPrescriptions() != null) {
            List<PrescriptionDto> rxList = booking.getPrescriptions().stream().map(rx -> {
                PrescriptionDto rxDto = new PrescriptionDto();
                rxDto.setName(rx.getName());
                rxDto.setDosage(rx.getDosage());
                rxDto.setInstructions(rx.getInstructions());
                rxDto.setTiming(rx.getTiming());
                rxDto.setFrequency(rx.getFrequency());
                rxDto.setComments(rx.getComments());
                rxDto.setStatus(rx.getStatus());
                return rxDto;
            }).collect(Collectors.toList());
            dto.setPrescriptions(rxList);
        }

        return dto;
    }

    @Override
    public BookingDataDto createBooking(BookingDataDto dto) {
        Patient patient = patientRepository.findByEmail(dto.getEmail())
                .orElseGet(() -> {
                    Patient p = new Patient();
                    p.setEmail(dto.getEmail());
                    return p;
                });

        patient.setName(dto.getName());
        patient.setPhone(dto.getPhone());
        patient.setIsNewPatient(dto.getIsNewPatient());
        patient.setInsurance(dto.getInsurance());
        if (dto.getChronicConditions() != null) patient.setChronicConditions(dto.getChronicConditions());
        if (dto.getAllergies() != null) patient.setAllergies(dto.getAllergies());

        patient = patientRepository.save(patient);

        Booking booking = new Booking();
        booking.setPatient(patient);
        booking.setType(dto.getType());
        booking.setSpecialty(dto.getSpecialty());
        booking.setDate(dto.getDate());
        booking.setTime(dto.getTime());
        booking.setReason(dto.getReason());
        booking.setStatus("confirmed");

        return mapToDto(bookingRepository.save(booking));
    }

    @Override
    public List<BookingDataDto> getAllBookings() {
        return bookingRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public BookingDataDto getBookingById(String id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        return mapToDto(booking);
    }

    @Override
    public BookingDataDto updateBookingStatus(String id, String status) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        booking.setStatus(status);
        return mapToDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDataDto updateBookingRoomAndToken(String id, String roomAssigned, String token) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        booking.setRoomAssigned(roomAssigned);
        booking.setToken(token);
        return mapToDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDataDto updateTelehealthLink(String id, String telehealthLink) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));
        booking.setTelehealthLink(telehealthLink);
        return mapToDto(bookingRepository.save(booking));
    }

    @Override
    public BookingDataDto updateClinicalEncounter(String id, BookingDataDto updates) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + id));

        if (updates.getDoctorNotes() != null) booking.setDoctorNotes(updates.getDoctorNotes());

        if (updates.getVitals() != null) {
            if (booking.getVitals() == null) booking.setVitals(new Vitals());
            booking.getVitals().setBp(updates.getVitals().getBp());
            booking.getVitals().setHr(updates.getVitals().getHr());
            booking.getVitals().setTemp(updates.getVitals().getTemp());
            booking.getVitals().setWeight(updates.getVitals().getWeight());
        }

        if (updates.getPrescriptions() != null) {
            if (booking.getPrescriptions() == null) {
                booking.setPrescriptions(new ArrayList<>());
            } else {
                booking.getPrescriptions().clear();
            }
            for (PrescriptionDto rxDto : updates.getPrescriptions()) {
                Prescription rx = new Prescription();
                rx.setBooking(booking);
                rx.setName(rxDto.getName());
                rx.setDosage(rxDto.getDosage());
                rx.setInstructions(rxDto.getInstructions());
                rx.setTiming(rxDto.getTiming());
                rx.setFrequency(rxDto.getFrequency());
                rx.setComments(rxDto.getComments());
                rx.setStatus(rxDto.getStatus() != null ? rxDto.getStatus() : "pending");
                booking.getPrescriptions().add(rx);
            }
        }

        if (updates.getLabRequests() != null) booking.setLabRequests(updates.getLabRequests());

        return mapToDto(bookingRepository.save(booking));
    }

    @Override
    public List<BookingDataDto> getPatientHistory(String email) {
        return bookingRepository.findAllByPatientEmail(email).stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public List<BookingDataDto> getActiveQueue() {
        String todayStr = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        List<String> activeStatuses = Arrays.asList("arrived", "in_session");
        return bookingRepository.findActiveQueue(todayStr, activeStatuses)
                .stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public BookingDataDto updatePatientProfile(String email, BookingDataDto profileData) {
        Patient patient = patientRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with email: " + email));
        if (profileData.getChronicConditions() != null) patient.setChronicConditions(profileData.getChronicConditions());
        if (profileData.getAllergies() != null) patient.setAllergies(profileData.getAllergies());
        patientRepository.save(patient);
        return profileData;
    }

    @Override
    public List<BookingDataDto> getAdminBlockedSlots(String date) {
        return new ArrayList<>();
    }
}
