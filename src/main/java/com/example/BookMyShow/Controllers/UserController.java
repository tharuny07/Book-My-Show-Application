package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.EntryDtos.UserEntryDto;
import com.example.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(UserEntryDto userEntryDto)
    {
        String response= userService.addUser(userEntryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
