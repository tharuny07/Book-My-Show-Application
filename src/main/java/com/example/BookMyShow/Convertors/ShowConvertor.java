package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.EntryDtos.ShowEntryDto;
import com.example.BookMyShow.Models.Show;

public class ShowConvertor {

    public static Show showEntryDtoToShow(ShowEntryDto showEntryDto){
        return Show.builder().showTime(showEntryDto.getShowTime())
                .showDate(showEntryDto.getShowDate()).showType(showEntryDto.getShowType()).build();
    }
}
