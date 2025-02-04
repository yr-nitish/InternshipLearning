package com.exampleateffigo.coursemanagement.service;

import com.exampleateffigo.coursemanagement.dto.ReviewRequestDTO;
import com.exampleateffigo.coursemanagement.dto.ReviewResponseDTO;
import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.entity.Reviews;
import com.exampleateffigo.coursemanagement.entity.Users;
import com.exampleateffigo.coursemanagement.mappers.ReviewMapper;
import com.exampleateffigo.coursemanagement.repository.CoursesRepository;
import com.exampleateffigo.coursemanagement.repository.ReviewsRepository;
import com.exampleateffigo.coursemanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    @Autowired
    private ReviewMapper reviewMapper;


    public ReviewResponseDTO addReview(ReviewRequestDTO reviewRequestDTO) {

        Users user = usersRepository.findById(reviewRequestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Courses course = coursesRepository.findById(reviewRequestDTO.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Reviews review = reviewMapper.toEntity(reviewRequestDTO);
        review.setUsers(user);
        review.setCourses(course);

        Reviews savedReview = reviewsRepository.save(review);
        return reviewMapper.toDTO(savedReview);
    }

    public List<ReviewResponseDTO> getAllReviews()
    {
        List<Reviews> reviews = reviewsRepository.findAll();
        return reviews.stream()
                .map(reviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteReview(long id)
    {
        reviewsRepository.deleteById(id);
    }

    public ReviewResponseDTO getReviewById(long id)
    {
        Reviews reviews = reviewsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        return reviewMapper.toDTO(reviews);
    }
}
