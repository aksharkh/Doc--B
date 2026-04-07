package com.example.Doc__B.service;

import com.example.Doc__B.dto.AnalyticsDto;
import com.example.Doc__B.dto.BookingDataDto;

import java.util.List;

public interface BookingService {
    BookingDataDto createBooking(BookingDataDto bookingDataDto);
    List<BookingDataDto> getAllBookings();
    BookingDataDto getBookingById(String id);
    BookingDataDto updateBookingStatus(String id, String status);
    BookingDataDto updateBookingRoomAndToken(String id, String roomAssigned, String token);
    BookingDataDto updateTelehealthLink(String id, String telehealthLink);
    BookingDataDto updateClinicalEncounter(String id, BookingDataDto updates);
    List<BookingDataDto> getPatientHistory(String email);
    List<BookingDataDto> getActiveQueue();
    BookingDataDto updatePatientProfile(String email, BookingDataDto profileData);
    List<BookingDataDto> getAdminBlockedSlots(String date);
    AnalyticsDto getAnalytics();
}
