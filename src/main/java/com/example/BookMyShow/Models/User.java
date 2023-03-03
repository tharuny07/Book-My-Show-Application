package com.example.BookMyShow.Models;

import javax.persistence.*;

import com.example.BookMyShow.ResponceDtos.TicketResponseDto;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true)
    private String mobileNo;
    private int age;
    private String address;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> bookedTickets;
}
