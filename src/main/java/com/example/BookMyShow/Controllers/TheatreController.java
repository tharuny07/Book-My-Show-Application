package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.EntryDtos.TheatreEntryDto;
import com.example.BookMyShow.Services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/theatres")
public class TheatreController {
    @Autowired
    TheatreService theatreService;

    public ResponseEntity<String> addTheatre(TheatreEntryDto theatreEntryDto){
        String response=theatreService.addTheatre(theatreEntryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
