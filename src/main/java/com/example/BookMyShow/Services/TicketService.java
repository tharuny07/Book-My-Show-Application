package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.TicketConvertor;
import com.example.BookMyShow.EntryDtos.TicketEntryDto;
import com.example.BookMyShow.Models.Show;
import com.example.BookMyShow.Models.ShowSeat;
import com.example.BookMyShow.Models.Ticket;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repositories.MovieRepository;
import com.example.BookMyShow.Repositories.ShowRepository;
import com.example.BookMyShow.Repositories.TicketRepository;
import com.example.BookMyShow.Repositories.UserRepository;
import com.example.BookMyShow.ResponceDtos.TicketResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public String bookTicket(TicketEntryDto ticketEntryDto)throws Exception{

        //Getting show entity to set the attributes in ticket entity
        Show show=showRepository.findById(ticketEntryDto.getShowId()).get();

        List<ShowSeat> showSeatList=show.getShowSeatList();
        List<String> requestSeats=ticketEntryDto.getRequestSeats();

        int totalAmount=0;
        String bookedSeats="";

        //checking if requested seats available or not
        boolean reqSeatsAvailableOrNot=seatsAvailableOrNot(showSeatList,requestSeats);
        //if seats are not available, throwing an exception.
        if(reqSeatsAvailableOrNot==false)   throw new Exception("Seats are already booked and not available to book");

        for(ShowSeat showSeat:showSeatList){
            String seatNo= showSeat.getSeatNo();

            if(requestSeats.contains(seatNo)){
                if(showSeat.isBooked()==false){
                    totalAmount+=showSeat.getPrice();
                    showSeat.setBooked(true);//setting the ticket to booked as it has been booked
                    showSeat.setBookedAt(new Date());//Time at seats has been booked

                    if(requestSeats.get(requestSeats.size()-1).equals(seatNo)) bookedSeats+=seatNo;
                    else bookedSeats+=seatNo+",";
                }
            }
        }
        User user=userRepository.findById(ticketEntryDto.getUserId()).get();

        //Setting the ticket attributes
        Ticket ticket= Ticket.builder().price(totalAmount).bookedSeats(bookedSeats)
                .theatreName(show.getTheatre().getName())
                .movieName(show.getMovie().getName())
                .user(user).showTiming(show.getShowTime()).showDate(show.getShowDate())
                .show(show).build();
         //Saving it in the database
        ticketRepository.save(ticket);
        //Setting the ticket attribute before saving user entity in the database
        user.getBookedTickets().add(ticket);
        userRepository.save(user);
         //Setting the ticket attribute before saving show entity in the database
        show.getTicketList().add(ticket);
        showRepository.save(show);


        String body = "Hi this is to confirm your booking for seat No "+bookedSeats +" for the movie : " +
                ticket.getMovieName()+". Come to the theatre "+show.getTheatre().getName()+", "+show.getTheatre().getAddress()+
                ". Show timings are "+ticket.getShowDate()+" "+ticket.getShowTiming();

       //For sending message that the ticket has booked to the userEmail.
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("bookmyshow707@gmail.com");
        mimeMessageHelper.setTo(user.getEmail());
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject("Confirming your booked Ticket");

        javaMailSender.send(mimeMessage);

        return "Tickets booked successfully. Your seatNos: "+bookedSeats;
    }
    public boolean seatsAvailableOrNot(List<ShowSeat> showSeatList,List<String> reqSeats){
        int count=0;

        for(ShowSeat showSeat:showSeatList)
        {
            if(reqSeats.contains(showSeat.getSeatNo())){
                if(showSeat.isBooked()==true){
                    return false;//if requested seats are already booked return false
                }else{
                    count++;
                }
            }
        }
        if(count==reqSeats.size()) return true;//Requested seats are available so return true

        return false;
    }
}
