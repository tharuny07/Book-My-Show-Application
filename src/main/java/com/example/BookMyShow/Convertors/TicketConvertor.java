package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Models.Ticket;
import com.example.BookMyShow.ResponceDtos.TicketResponseDto;

public class TicketConvertor {
    public static TicketResponseDto convertTicketToTicketResponseDto(Ticket ticket)
    {
          return TicketResponseDto.builder().ticketID(ticket.getId()).totalAmount(ticket.getPrice())
                  .theatreName(ticket.getTheatreName()).movieName(ticket.getMovieName())
                  .showDate(ticket.getShowDate()).showTime(ticket.getShowTiming())
                  .bookedSeats(ticket.getBookedSeats()).build();
    }
}
