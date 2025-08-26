package com.githup.seatbooking.service;

import com.githup.seatbooking.entity.Seat;
import com.githup.seatbooking.dto.respone.BookingResult;
import com.githup.seatbooking.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SeatBookingService  {

    private final SeatRepository seatRepository;


    @Transactional
    public BookingResult bookSeatPessimistic (String seatNumber, String name){

        Seat seat = seatRepository.findAvailableSeatWithLock(seatNumber)
                .orElseThrow(() -> new RuntimeException("Seat is Not Found"));

        seat.setIsAvailable(false);
        seat.setBookedBy(name);
        seat.setBookingTime(LocalDateTime.now());

        seatRepository.save(seat);
        return new BookingResult(true, "Seat booked successfully", seat);

    }


    public BookingResult bookSeatNormal (String seatNumber, String name){

        Seat seat = seatRepository.findAvailableSeatNormal(seatNumber)
                .orElseThrow(() -> new RuntimeException("Seat is Not Found"));

        seat.setIsAvailable(false);
        seat.setBookedBy(name);
        seat.setBookingTime(LocalDateTime.now());

        seatRepository.save(seat);
        return new BookingResult(true, "Seat booked successfully", seat);

    }

}
