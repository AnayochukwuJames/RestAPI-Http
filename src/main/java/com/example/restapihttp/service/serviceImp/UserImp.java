package com.example.restapihttp.service.serviceImp;

import com.example.restapihttp.dto.request.SignUpRequest;
import com.example.restapihttp.dto.request.UpdateRequest;
import com.example.restapihttp.dto.response.SignUpResponse;
import com.example.restapihttp.dto.response.UserResponse;
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
    @Override
    public ResponseEntity<UserResponse> getUserById(Long id){
       Users user = userRepository.findById(id)
               .orElseThrow(()-> new RuntimeException("user not found"));
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


}
