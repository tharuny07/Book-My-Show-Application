package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.EntryDtos.MovieEntryDto;
import com.example.BookMyShow.Models.Movie;

public class MovieConvertor {

    public static Movie convertMovieEntryDtoToMovieEntity(MovieEntryDto movieEntryDto){

        Movie movie=Movie.builder().genre(movieEntryDto.getGenre())
                .name(movieEntryDto.getName()).rating(movieEntryDto.getRating())
                .language(movieEntryDto.getLanguage()).duration(movieEntryDto.getDuration()).build();

        return movie;
    }
}
