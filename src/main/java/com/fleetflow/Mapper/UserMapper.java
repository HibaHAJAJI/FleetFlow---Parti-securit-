package com.fleetflow.Mapper;


import com.fleetflow.Dto.UserDto;
import com.fleetflow.Entity.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

   Users toEntity(UserDto dto);

   UserDto toDto(Users user);
}
