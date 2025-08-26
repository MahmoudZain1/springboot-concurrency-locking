package com.githup.seatbooking;

import com.githup.seatbooking.service.SeatBookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExclusiveBookingTest {


    @Autowired
    private  SeatBookingService seatBookingService;

    @Test
    void testExclusiveBooking() throws InterruptedException {
        Runnable task1 = () -> seatBookingService.bookSeatPessimistic("C1", "Mahmoud");
        Runnable task2 = () -> seatBookingService.bookSeatPessimistic("C1", "Zain");

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
