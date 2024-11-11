package com.example.E_Learning_Platform.UserController;

import com.example.E_Learning_Platform.Dto.UserDTO;
import com.example.E_Learning_Platform.Dto.LoginDTO;
import com.example.E_Learning_Platform.Responses.LoginResponse;
import com.example.E_Learning_Platform.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/auth")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String greet() {
        return "welcome to registration page";
    }

    @PostMapping(path = "/register")
    public String saveUsers(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);
        return id;
    }


    @GetMapping("/login")
    public String greet2() {
        return "welcome to login page";
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginResponse loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}