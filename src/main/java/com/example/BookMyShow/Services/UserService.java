package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.TicketConvertor;
import com.example.BookMyShow.Convertors.UserConvertor;
import com.example.BookMyShow.EntryDtos.UserEntryDto;
import com.example.BookMyShow.Models.Ticket;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repositories.UserRepository;
import com.example.BookMyShow.ResponceDtos.TicketResponseDto;
import com.example.BookMyShow.ResponceDtos.UserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto){

        //Using Builder annotation to build the user entity
        //Builder same like new keyword. But less code required to set the attributes
        User user= UserConvertor.convertUserEntryDtoToUser(userEntryDto);
        //Saving the User in the database
        userRepository.save(user);
        return "User added Successfully";
    }

    public UserResponseDto getUserByEmailId(String emailID){
        //Getting the user from the database by writing the abstract method in the userRepository
        User user=userRepository.findByEmail(emailID);
        List<Ticket> bookedTickets=user.getBookedTickets();
        List<TicketResponseDto> bookedTicketResponseDto=new ArrayList<>();
        //converting ticket into ticketResponseDto to avoid infinite loop
        for(Ticket ticket:bookedTickets){
            bookedTicketResponseDto.add(TicketConvertor.convertTicketToTicketResponseDto(ticket));
        }

        //converting user into userResponseDto by using static convertor method
        UserResponseDto userResponseDto= UserConvertor.convertUserToUserResponseDto(user);
        userResponseDto.setBookedTickets(bookedTicketResponseDto);

        return userResponseDto;
    }
}
