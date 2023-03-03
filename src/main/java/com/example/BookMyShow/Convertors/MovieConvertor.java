package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.EntryDtos.MovieEntryDto;
import com.example.BookMyShow.Models.Movie;
import com.example.BookMyShow.ResponceDtos.MovieResponseDto;

public class MovieConvertor {

    public static Movie convertMovieEntryDtoToMovieEntity(MovieEntryDto movieEntryDto){

        Movie movie=Movie.builder().genre(movieEntryDto.getGenre())
                .name(movieEntryDto.getName()).rating(movieEntryDto.getRating())
                .language(movieEntryDto.getLanguage()).duration(movieEntryDto.getDuration()).build();

        return movie;
    }
    public static MovieResponseDto convertMovieToMovieResponseDto(Movie movie){
        return MovieResponseDto.builder().name(movie.getName()).duration(movie.getDuration()).genre(movie.getGenre())
                .language(movie.getLanguage()).rating(movie.getRating()).build();
    }
}
