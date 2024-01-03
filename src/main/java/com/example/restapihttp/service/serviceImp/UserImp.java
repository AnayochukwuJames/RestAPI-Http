package com.example.restapihttp.service.serviceImp;

import com.example.restapihttp.dto.request.LoginRequest;
import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.request.UpdateRequest;
import com.example.restapihttp.dto.response.LoginResponse;
import com.example.restapihttp.dto.response.SignUpResponse;
import com.example.restapihttp.dto.response.UserResponse;
import com.example.restapihttp.exception.UserAlreadyExistException;
import com.example.restapihttp.exception.UserNotFoundException;
import com.example.restapihttp.mapper.UserMapper;
import com.example.restapihttp.model.Users;
import com.example.restapihttp.repository.UserRepository;
import com.example.restapihttp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<SignUpResponse> createUsers(SignUpRequest request){
        if(userRepository.existsByEmailOrPhoneNumber(request.getEmail(),request.getPhoneNumber())){
            throw new UserAlreadyExistException("user have already registered");
        }
        Users users = userRepository.save(UserMapper.mapSignUpRequestToUsers(request));
        return new ResponseEntity<>(UserMapper.mapSignUpResponse(users), HttpStatus.CREATED);
    }
    @Override
    public ResponseEntity<UserResponse> getUserById(Long id){
       Users user = userRepository.findById(id)
               .orElseThrow(()-> new UserNotFoundException("user not found"));
       return  new ResponseEntity<>(UserMapper.mapUserResponse(user),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserResponse> updateUser(UpdateRequest request, Long id){
       Users users = userRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("User not found"));
       users =userRepository.save(UserMapper.mapUpdateRequestToUser(users,request));
       return new ResponseEntity<>(UserMapper.mapUserResponse(users),HttpStatus.OK);
    }
    @Override
    public ResponseEntity<String> deleteUser(Long id){
        userRepository.deleteById(id);
       return new ResponseEntity<>("user deleted successfully",HttpStatus.OK);
    }
    @Override
    public ResponseEntity<List<UserResponse>> getAllUser(){
        List<UserResponse>  users = userRepository.findAll().stream().map(UserMapper::mapUserResponse)
                .collect(Collectors.toList());
        return  new ResponseEntity<>(users,HttpStatus.OK);
    }
//    @Override
//    public ResponseEntity<LoginResponse> login(LoginRequest request){
//        if(userRepository.existsByEmail(request.getEmail()));
//        throw new RuntimeException("user already login");
//        Users users = new Users(LoginRequest)

    }