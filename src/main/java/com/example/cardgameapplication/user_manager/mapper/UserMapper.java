package com.example.cardgameapplication.user_manager.mapper;

import com.example.cardgameapplication.user_manager.dto.UserDto;
import com.example.cardgameapplication.user_manager.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.InjectionStrategy.FIELD;

@Mapper(injectionStrategy = FIELD, componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "user.id")
    @Mapping(target = "login", source = "user.login")
    @Mapping(target = "password", source = "user.password")
    @Mapping(target = "firstname", source = "user.firstname")
    @Mapping(target = "surname", source = "user.surname")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "cardDtos", expression = "java(null)")
    UserDto toUserDto(User user);

    @Mapping(target = "id", source = "userDto.id")
    @Mapping(target = "login", source = "userDto.login")
    @Mapping(target = "password", source = "userDto.password")
    @Mapping(target = "firstname", source = "userDto.firstname")
    @Mapping(target = "surname", source = "userDto.surname")
    @Mapping(target = "email", source = "userDto.email")
    User toUser(UserDto userDto);
}
