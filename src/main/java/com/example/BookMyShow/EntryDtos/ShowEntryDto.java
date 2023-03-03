package com.example.BookMyShow.EntryDtos;

import com.example.BookMyShow.Enums.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {
    private LocalTime showTime;
    private LocalDate showDate;
    private ShowType showType;
    private int priceForClassic;
    private int priceForPremium;
    private int movieId;
    private int theatreId;



}
