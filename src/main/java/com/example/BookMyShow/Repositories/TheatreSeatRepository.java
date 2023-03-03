package com.example.BookMyShow.Repositories;

import com.example.BookMyShow.Models.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreSeatRepository extends JpaRepository<TheatreSeat,Integer> {
}
