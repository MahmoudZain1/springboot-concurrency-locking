package com.githup.seatbooking.Controller;

import com.githup.seatbooking.dto.respone.BookingResult;
import com.githup.seatbooking.service.SeatBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seats")
@RequiredArgsConstructor
public class SeatBookingController {

    private final SeatBookingService seatBookingService;

    @PostMapping("/book/pessimistic")
    public BookingResult bookSeatPessimistic(
            @RequestParam String seatNumber,
            @RequestParam String name
    ) {
        return seatBookingService.bookSeatPessimistic(seatNumber, name);
    }


    @PostMapping("/book/normal")
    public BookingResult bookSeatNormal(
            @RequestParam String seatNumber,
            @RequestParam String name
    ) {
        return seatBookingService.bookSeatNormal(seatNumber, name);
    }
}
