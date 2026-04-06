package com.example.Doc__B.repository;

import com.example.Doc__B.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

    @Query("SELECT b FROM Booking b WHERE b.patient.email = :email ORDER BY b.id DESC")
    List<Booking> findAllByPatientEmail(@Param("email") String email);
    
    @Query("SELECT b FROM Booking b WHERE b.date = :date AND b.status IN :statuses")
    List<Booking> findActiveQueue(@Param("date") String date, @Param("statuses") List<String> statuses);

    List<Booking> findAllByDate(String date);
}
