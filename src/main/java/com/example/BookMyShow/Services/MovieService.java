package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.MovieConvertor;
import com.example.BookMyShow.EntryDtos.MovieEntryDto;
import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.Repositories.MovieRepository;
import com.example.BookMyShow.ResponceDtos.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public String addMovie(MovieEntryDto movieEntryDto){

        //Using the static convert method to convert movieEntryDto to movie Entity
        //We are converting because Our repository layer only deals with the Entities
        Movie movie= MovieConvertor.convertMovieEntryDtoToMovieEntity(movieEntryDto);

        movieRepository.save(movie);//Saving Movie ENtity to the Database

        return "Movie added successfully";
    }

    public MovieResponseDto getMovieByName(String movieName){
        //Getting the movie from the database by writing abstract method for getting the movie entity using the movieName
        Movie movie=movieRepository.findByName(movieName);
        //Converting the movie Entity to the movie response dto.
        //As we gonna send it as the response to the user
        MovieResponseDto movieResponseDto=MovieConvertor.convertMovieToMovieResponseDto(movie);

        return movieResponseDto;
    }
}
