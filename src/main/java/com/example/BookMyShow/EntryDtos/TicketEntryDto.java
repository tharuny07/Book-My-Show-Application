package com.example.BookMyShow.EntryDtos;

import lombok.Data;

import java.util.List;

@Data
public class TicketEntryDto {
    private int showId;
    private List<String> requestSeats;
    private int userId;
}
