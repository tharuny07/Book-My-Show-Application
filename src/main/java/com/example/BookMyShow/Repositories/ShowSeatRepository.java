package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
}
