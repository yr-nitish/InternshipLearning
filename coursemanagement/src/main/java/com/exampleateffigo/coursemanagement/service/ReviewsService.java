package com.exampleateffigo.coursemanagement.service;

import com.exampleateffigo.coursemanagement.entity.Courses;
import com.exampleateffigo.coursemanagement.entity.Reviews;
import com.exampleateffigo.coursemanagement.entity.Users;
import com.exampleateffigo.coursemanagement.repository.CoursesRepository;
import com.exampleateffigo.coursemanagement.repository.ReviewsRepository;
import com.exampleateffigo.coursemanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CoursesRepository coursesRepository;


    public Reviews addReview(long userId, long courseId, int rating, String comment) {

        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Courses course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Reviews review = new Reviews();
        review.setUsers(user);
        review.setCourses(course);
        review.setRating(rating);
        review.setComment(comment);

        return reviewsRepository.save(review);
    }

    public List<Reviews> getAllReviews()
    {
        return reviewsRepository.findAll();
    }

    public void deleteReview(long id)
    {
        reviewsRepository.deleteById(id);
    }

    public Optional<Reviews> getReviewById(long id)
    {
        return reviewsRepository.findById(id);
    }
}
