package com.example.BookMyShow.ResponceDtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
public class TicketResponseDto {
    private int ticketID;
    private int totalAmount;
    private String movieName;
    private String theatreName;
    private String bookedSeats;
    private LocalDate showDate;
    private LocalTime showTime;
}
