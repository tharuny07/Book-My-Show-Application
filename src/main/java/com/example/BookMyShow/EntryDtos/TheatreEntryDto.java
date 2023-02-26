package com.example.BookMyShow.EntryDtos;

import lombok.Data;

@Data
public class TheatreEntryDto {
    private String name;
    private String address;
    private int noOfClassicSeats;
    private int noOfPremiumSeats;

}
