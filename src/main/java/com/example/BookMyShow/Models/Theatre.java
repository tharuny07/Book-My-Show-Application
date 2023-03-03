package com.example.BookMyShow.Models;

import com.example.BookMyShow.Enums.SeatType;
import javax.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "theatres")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<Show> showList;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreSeat> theatreSeatList;

}
