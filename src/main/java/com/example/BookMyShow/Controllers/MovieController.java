package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.EntryDtos.MovieEntryDto;
import com.example.BookMyShow.ResponceDtos.MovieResponseDto;
import com.example.BookMyShow.Services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/addMovie")
    public ResponseEntity<String> addMovie(@RequestBody MovieEntryDto movieEntryDto){
        String response= movieService.addMovie(movieEntryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/getMovie")
    public ResponseEntity<MovieResponseDto> getMovieByName(@RequestParam String movieName){

        MovieResponseDto movieResponseDto=movieService.getMovieByName(movieName);
        return new ResponseEntity<>(movieResponseDto,HttpStatus.FOUND);
    }
}
