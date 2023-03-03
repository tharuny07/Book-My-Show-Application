package com.example.BookMyShow.Controllers;

import com.example.BookMyShow.EntryDtos.UserEntryDto;
import com.example.BookMyShow.ResponceDtos.UserResponseDto;
import com.example.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserEntryDto userEntryDto)
    {
        String response= userService.addUser(userEntryDto);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
   @GetMapping("getUser")
    public ResponseEntity<UserResponseDto> getUserByEmail(@RequestParam String email){
       UserResponseDto userResponseDto=userService.getUserByEmailId(email);
       return new ResponseEntity<>(userResponseDto,HttpStatus.FOUND);
    }
}
