package com.exampleateffigo.coursemanagement.mappers;

import com.exampleateffigo.coursemanagement.dto.CourseRequestDTO;
import com.exampleateffigo.coursemanagement.dto.CourseResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Courses;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    // Entity → DTO
    @Mapping(target = "courseId", source = "courseId")
    @Mapping(target = "courseName", source = "courseName")
    @Mapping(target = "coursePrice", source = "coursePrice")
    @Mapping(target = "courseCategory", source = "courseCategory")
    CourseResponseDTO toDTO(Courses courses);

    // DTO → Entity
    @Mapping(target = "courseId", ignore = true) // Auto-generated in DB
    @Mapping(target = "courseName", source = "courseName")
    @Mapping(target = "coursePrice", source = "coursePrice")
    @Mapping(target = "courseCategory", source = "courseCategory")
    Courses toEntity(CourseRequestDTO courseRequestDTO);
}
