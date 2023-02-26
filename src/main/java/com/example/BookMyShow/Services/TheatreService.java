package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.TheatreConvertor;
import com.example.BookMyShow.EntryDtos.TheatreEntryDto;
import com.example.BookMyShow.Models.Theatre;
import org.springframework.stereotype.Service;

@Service
public class TheatreService {


    public String addTheatre(TheatreEntryDto theatreEntryDto){

        Theatre theatre= TheatreConvertor.convertTheatreDtoToTheatreEntity(theatreEntryDto);
        return "";
    }
}
