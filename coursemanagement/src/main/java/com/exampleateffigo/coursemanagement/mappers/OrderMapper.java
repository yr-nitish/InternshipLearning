package com.exampleateffigo.coursemanagement.mappers;

import com.exampleateffigo.coursemanagement.dto.OrderRequestDTO;
import com.exampleateffigo.coursemanagement.dto.OrderResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "userId", source = "users.userId")
    @Mapping(target = "courseId", source = "courses.courseId")
    OrderResponseDTO toDTO(Orders orders);

    @Mapping(target = "users.userId", source = "userId")
    @Mapping(target = "courses.courseId", source = "courseId")
    Orders toEntity(OrderRequestDTO orderRequestDTO);
}
