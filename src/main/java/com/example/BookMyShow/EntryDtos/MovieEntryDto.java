package com.example.BookMyShow.EntryDtos;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;

import lombok.Data;

@Data
public class MovieEntryDto {

    private String name;
    private double rating;
    private int duration;
    private Language language;
    private Genre genre;
}
