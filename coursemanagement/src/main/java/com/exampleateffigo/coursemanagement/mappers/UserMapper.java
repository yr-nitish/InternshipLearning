package com.exampleateffigo.coursemanagement.mappers;

import com.exampleateffigo.coursemanagement.dto.UserRequestDTO;
import com.exampleateffigo.coursemanagement.dto.UserResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

//    @Mapping(target = "userName", source = "userName")
//    @Mapping(target = "userEmail", source = "userEmail")

    UserResponseDTO toResponseDTO(Users users);

    Users toEntity(UserRequestDTO userRequestDTO);
}
