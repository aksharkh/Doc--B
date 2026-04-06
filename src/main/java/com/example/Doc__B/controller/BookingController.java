package com.example.Doc__B.controller;

import com.example.Doc__B.dto.BookingDataDto;
import com.example.Doc__B.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<BookingDataDto> createBooking(@RequestBody BookingDataDto dto) {
        return ResponseEntity.ok(bookingService.createBooking(dto));
    }

    @GetMapping
    public ResponseEntity<List<BookingDataDto>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDataDto> getBookingById(@PathVariable String id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<BookingDataDto> updateStatus(@PathVariable String id, @RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(bookingService.updateBookingStatus(id, payload.get("status")));
    }

    @PatchMapping("/{id}/room")
    public ResponseEntity<BookingDataDto> updateRoomAndToken(@PathVariable String id, @RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(bookingService.updateBookingRoomAndToken(id, payload.get("roomAssigned"), payload.get("token")));
    }

    @PatchMapping("/{id}/telehealth")
    public ResponseEntity<BookingDataDto> updateTelehealth(@PathVariable String id, @RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(bookingService.updateTelehealthLink(id, payload.get("telehealthLink")));
    }

    @PutMapping("/{id}/clinical")
    public ResponseEntity<BookingDataDto> updateClinicalEncounter(@PathVariable String id, @RequestBody BookingDataDto dto) {
        return ResponseEntity.ok(bookingService.updateClinicalEncounter(id, dto));
    }

    @GetMapping("/history")
    public ResponseEntity<List<BookingDataDto>> getPatientHistory(@RequestParam String email) {
        return ResponseEntity.ok(bookingService.getPatientHistory(email));
    }

    @GetMapping("/queue")
    public ResponseEntity<List<BookingDataDto>> getActiveQueue() {
        return ResponseEntity.ok(bookingService.getActiveQueue());
    }

    @PutMapping("/patient/{email}")
    public ResponseEntity<BookingDataDto> updatePatientProfile(@PathVariable String email, @RequestBody BookingDataDto dto) {
        return ResponseEntity.ok(bookingService.updatePatientProfile(email, dto));
    }
}
