package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.Genre;
import com.example.BookMyShow.Enums.Language;
import javax.persistence.*;
import lombok.*;

//import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double rating;
    private int duration;
    @Enumerated(value = EnumType.STRING)
    private Language language;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> listOfShows;

}
