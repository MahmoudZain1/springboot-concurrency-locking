package com.githup.seatbooking.repository;

import com.githup.seatbooking.entity.Seat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface SeatRepository extends JpaRepository<Seat, Long> {


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("""
            select s from Seat s where s.seatNumber=:seatNumber and s.isAvailable = true
            """)
    Optional<Seat>findAvailableSeatWithLock(@Param("seatNumber") String seatNumber);

    @Query("""
            select s from Seat s where s.seatNumber=:seatNumber and s.isAvailable = true
            """)
    Optional<Seat>findAvailableSeatNormal(@Param("seatNumber") String seatNumber);







}
