package com.example.BookMyShow.Enums;

import com.example.BookMyShow.Models.Show;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "show_seats")
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Boolean isBooked;
    private int price;
    private int seatNo;
    private SeatType seatType;
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Show show;
}
