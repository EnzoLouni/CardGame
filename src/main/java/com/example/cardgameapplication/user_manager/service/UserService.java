package com.example.cardgameapplication.user_manager.service;

import com.example.cardgameapplication.user_manager.dao.UserRepository;
import com.example.cardgameapplication.user_manager.dto.AuthDto;
import com.example.cardgameapplication.user_manager.dto.UserDto;
import com.example.cardgameapplication.user_manager.mapper.UserMapper;
import com.example.cardgameapplication.user_manager.model.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Validated
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDto getUser(Integer userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new ResourceNotFoundException();
        }
        return userMapper.toUserDto(user.get());
    }

    public void updateUser(Integer id, UserDto newUserDto) {
        try {
            getUser(id);
            newUserDto.setId(id);
            userRepository.save(userMapper.toUser(newUserDto));
        } catch(Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    public void deleteUser(Integer userId) {
        try {
            userRepository.deleteById(userId);
        } catch(Exception e) {
            throw new ResourceNotFoundException();
        }
    }

    public boolean createUser(UserDto user) {
        //boolean isAnUsedLogin = userRepository.hasAnExistingLogin(user.getLogin());
        if(true){
            user.setPwd(DigestUtils.sha256Hex(user.getPwd()));
            userRepository.save(userMapper.toUser(user));
            return true;
        }
        else {
            return false;
        }
    }

    public boolean authenticate(AuthDto request) {
        String passwordGiven = DigestUtils.sha256Hex(request.getPassword());
        String passwordRelated = userRepository.getPasswordByLogin(request.getLogin());
        return passwordGiven.equals(passwordRelated);
    }

    public List<UserDto> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false).map(userMapper::toUserDto).collect(toList());//  stream().map(cardMapper::toCardDto).collect(toList());
    }
}
