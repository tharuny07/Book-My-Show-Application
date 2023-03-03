package com.example.BookMyShow.ResponceDtos;

import com.example.BookMyShow.Models.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class UserResponseDto {

    private String username;
    private String emailID;
    private String phoneNo;
    private int age;
    private String address;
    private List<TicketResponseDto> bookedTickets;
}
