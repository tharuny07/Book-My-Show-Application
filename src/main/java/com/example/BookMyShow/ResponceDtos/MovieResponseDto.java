package com.example.BookMyShow.ResponceDtos;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MovieResponseDto {
    private String name;
    private double rating;
    private int duration;
    private Language language;
    private Genre genre;

}
