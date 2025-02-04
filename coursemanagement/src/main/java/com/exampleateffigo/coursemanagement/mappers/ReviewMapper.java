package com.exampleateffigo.coursemanagement.mappers;

import com.exampleateffigo.coursemanagement.dto.ReviewRequestDTO;
import com.exampleateffigo.coursemanagement.dto.ReviewResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Reviews;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewMapper INSTANCE = Mappers.getMapper(ReviewMapper.class);

    //  Convert Entity → DTO (Include userId & courseId)
    @Mapping(target = "userId", source = "users.userId")
    @Mapping(target = "courseId", source = "courses.courseId")
    ReviewResponseDTO toDTO(Reviews reviews);

    //  Convert DTO → Entity (Ignore setting users & courses here)
    @Mapping(target = "reviewId", ignore = true) // ID is auto-generated
    @Mapping(target = "users", ignore = true) // Set manually in service
    @Mapping(target = "courses", ignore = true) // Set manually in service
    Reviews toEntity(ReviewRequestDTO reviewRequestDTO);
}
