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
    @Mapping(target = "pwd", source = "user.pwd")
    @Mapping(target = "firstName", source = "user.firstName")
    @Mapping(target = "surName", source = "user.surName")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "cardDtos", expression = "java(null)")
    UserDto toUserDto(User user);

    @Mapping(target = "id", source = "userDto.id")
    @Mapping(target = "login", source = "userDto.login")
    @Mapping(target = "pwd", source = "userDto.pwd")
    @Mapping(target = "firstName", source = "userDto.firstName")
    @Mapping(target = "surName", source = "userDto.surName")
    @Mapping(target = "email", source = "userDto.email")
    User toUser(UserDto userDto);
}
