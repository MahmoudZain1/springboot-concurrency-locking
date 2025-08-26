package com.githup.seatbooking.dto.respone;

import com.githup.seatbooking.entity.Seat;

public record BookingResult( boolean success, String message, Seat seat) {
}
