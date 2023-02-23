package com.example.BookMyShow.Services;

import com.example.BookMyShow.EntryDtos.UserEntryDto;
import com.example.BookMyShow.Models.User;
import com.example.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String addUser(UserEntryDto userEntryDto){

        User user= User.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).email(userEntryDto.getEmail())
                .address(userEntryDto.getAddress()).mobileNo(userEntryDto.getMobileNo()).build();

        userRepository.save(user);
        return "User added Successfully";
    }
}
