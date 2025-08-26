package com.githup.seatbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;

@Entity
@Table(name = "seats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "is_available")
    private Boolean isAvailable = true;

    @Column(name = "booked_by")
    private String bookedBy;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime;

    @Version
    private Long version;


}
