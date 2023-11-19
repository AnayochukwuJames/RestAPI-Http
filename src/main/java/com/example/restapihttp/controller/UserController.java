package com.example.restapihttp.controller;

import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.request.UpdateRequest;
import com.example.restapihttp.dto.response.SignUpResponse;
import com.example.restapihttp.dto.response.UserResponse;
import com.example.restapihttp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    public final UserService userService;
    @PostMapping("/creat-user")
    public ResponseEntity<SignUpResponse> createUser(@RequestBody SignUpRequest request){
        return userService.createUsers(request);
    }
    @GetMapping("get-user/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PutMapping("")
    public ResponseEntity<UserResponse> updateUser(@RequestBody UpdateRequest request,@PathVariable Long id){
        return userService.updateUser(request, id);
    }
    @DeleteMapping("delete-user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        return userService.deleteUser(id);
    }

    @GetMapping("get-all-users")
    public ResponseEntity<List<UserResponse>> getAllUser(){
        return userService.getAllUser();
    }

}
