package com.example.restapihttp.service.serviceImp;

import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.response.SignUpResponse;
import com.example.restapihttp.mapper.UserMapper;
import com.example.restapihttp.model.Users;
import com.example.restapihttp.repository.UserRepository;
import com.example.restapihttp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<SignUpResponse> createUsers(SignUpRequest request){
        if(userRepository.existsByEmailOrPhoneNumber(request.getEmail(),request.getPhoneNumber())){
            throw new RuntimeException("user have already registered");
        }
        Users users = userRepository.save(UserMapper.mapSignUpRequestToUsers(request));
        return new ResponseEntity<>(UserMapper.mapSignUpResponse(users), HttpStatus.CREATED);
    }


}
