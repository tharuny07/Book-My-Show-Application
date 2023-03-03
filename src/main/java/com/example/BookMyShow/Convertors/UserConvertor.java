package com.example.BookMyShow.Convertors;


import com.example.BookMyShow.EntryDtos.UserEntryDto;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.ResponceDtos.UserResponseDto;

public class UserConvertor {
    public static UserResponseDto convertUserToUserResponseDto(User user)
    {
        return UserResponseDto.builder().username(user.getName()).age(user.getAge()).emailID(user.getEmail())
                .address(user.getAddress()).phoneNo(user.getMobileNo()).build();
    }
    public static User convertUserEntryDtoToUser(UserEntryDto userEntryDto){
        return User.builder().name(userEntryDto.getName()).email(userEntryDto.getEmail()).mobileNo(userEntryDto.getMobileNo())
                .address(userEntryDto.getAddress()).age(userEntryDto.getAge()).build();
    }
}
