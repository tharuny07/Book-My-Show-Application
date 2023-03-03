package com.example.BookMyShow.Services;

import com.example.BookMyShow.Convertors.ShowConvertor;
import com.example.BookMyShow.EntryDtos.ShowEntryDto;
import com.example.BookMyShow.Enums.SeatType;
import com.example.BookMyShow.Models.*;
import com.example.BookMyShow.Repositories.MovieRepository;
import com.example.BookMyShow.Repositories.ShowRepository;
import com.example.BookMyShow.Repositories.ShowSeatRepository;
import com.example.BookMyShow.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {


    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;

    public String addShow(ShowEntryDto showEntryDto){
       // Using static convertor method converting showEntryDto into the show entity
        Show show= ShowConvertor.showEntryDtoToShow(showEntryDto);

        Movie movie=movieRepository.findById(showEntryDto.getMovieId()).get();//Getting Movie entity from db. Getting it to set for the show
        Theatre theatre=theatreRepository.findById(showEntryDto.getTheatreId()).get();//Getting theatre entity from db. Getting it to set for the show

        show.setMovie(movie);//Setting movie attribute to the show
        show.setTheatre(theatre);//Setting the theatre attribute to the show

        //Using create showSeat function we are creating the showSeat and adding setting it the show.
        List<ShowSeat> showSeatList=createShowSeat(showEntryDto,show);

        show.setShowSeatList(showSeatList);
        showRepository.save(show);//Saving show entity in the Database

        movie.getListOfShows().add(show);
        movieRepository.save(movie);//Saving the Movie entity in the Database

        theatre.getShowList().add(show);
        theatreRepository.save(theatre);//Saving the theatre entity in the Database

        return "Show has been added successfully";
    }
    public List<ShowSeat> createShowSeat(ShowEntryDto showEntryDto,Show show){

        List<ShowSeat> showSeatList=new ArrayList<>();
        List<TheatreSeat> theatreSeatList=show.getTheatre().getTheatreSeatList();//Getting the theatreSeats
        //We are using the theatreSeats to create ShowSeats
        //TheatreSeats are just physical thing and by creating show seat we are using the theatreSeats
        //TheatreSeats are Potential energy and we are converting the potential energy into kinetic energy by creating the showSeats

        for(TheatreSeat theatreSeat:theatreSeatList){//Traversing OVER the theatreSeats List and meanWhile creating the showSeat
            ShowSeat showSeat= new ShowSeat();
            showSeat.setSeatType(theatreSeat.getSeatType());
            showSeat.setSeatNo((theatreSeat.getSeatNo()));

            //Knowing whether seats are classic or premium
            //So that we can set the price according to it
            if(theatreSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showEntryDto.getPriceForClassic());
            }else{
                showSeat.setPrice(showEntryDto.getPriceForPremium());
            }

            //AS showSeats are created just now, and they are not yet booked. so setting it to false
            showSeat.setBooked(false);
            showSeat.setShow(show);//setting the foreign key of showSeat.

            //Adding showSeat to the listOfShowSeats
            showSeatList.add(showSeat);
        }
        return showSeatList;
    }
}
