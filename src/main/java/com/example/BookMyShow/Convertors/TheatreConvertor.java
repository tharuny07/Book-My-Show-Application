package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.EntryDtos.TheatreEntryDto;
import com.example.BookMyShow.Models.Theatre;

public class TheatreConvertor {

    public static Theatre convertTheatreDtoToTheatreEntity(TheatreEntryDto theatreEntryDto){
        return Theatre.builder().address(theatreEntryDto.getAddress()).name(theatreEntryDto.getName()).build();
    }
}
