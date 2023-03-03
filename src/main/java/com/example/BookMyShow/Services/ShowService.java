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
        Show show= ShowConvertor.showEntryDtoToShow(showEntryDto);
        Movie movie=movieRepository.findById(showEntryDto.getMovieId()).get();
        Theatre theatre=theatreRepository.findById(showEntryDto.getTheatreId()).get();
        show.setMovie(movie);
        show.setTheatre(theatre);
        List<ShowSeat> showSeatList=createShowSeat(showEntryDto,show);
        show.setShowSeatList(showSeatList);
        showRepository.save(show);
        movie.getListOfShows().add(show);
        movieRepository.save(movie);
        theatre.getShowList().add(show);
        theatreRepository.save(theatre);

        return "Show has been added successfully";
    }
    public List<ShowSeat> createShowSeat(ShowEntryDto showEntryDto,Show show){
        List<ShowSeat> showSeatList=new ArrayList<>();
        List<TheatreSeat> theatreSeatList=show.getTheatre().getTheatreSeatList();

        for(TheatreSeat theatreSeat:theatreSeatList){
            ShowSeat showSeat= new ShowSeat();
            showSeat.setSeatType(theatreSeat.getSeatType());
            showSeat.setSeatNo((theatreSeat.getSeatNo()));

            if(theatreSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showEntryDto.getPriceForClassic());
            }else{
                showSeat.setPrice(showEntryDto.getPriceForPremium());
            }

            showSeat.setBooked(false);
            showSeat.setShow(show);

            showSeatList.add(showSeat);
        }
        return showSeatList;
    }
}
