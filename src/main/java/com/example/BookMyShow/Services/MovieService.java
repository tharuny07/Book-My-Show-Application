package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.MovieConvertor;
import com.example.BookMyShow.EntryDtos.MovieEntryDto;
import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto){

        Movie movie= MovieConvertor.convertMovieEntryDtoToMovieEntity(movieEntryDto);
        movieRepository.save(movie);

        return "Movie added successfully";
    }
}
