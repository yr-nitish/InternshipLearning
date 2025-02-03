package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.dto.ReviewRequest;
import com.exampleateffigo.coursemanagement.entity.Reviews;
import com.exampleateffigo.coursemanagement.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping
    public ResponseEntity<Reviews> addReview(@RequestBody ReviewRequest request) {
        Reviews review = reviewsService.addReview(request.getUserId(), request.getCourseId(), request.getRating(), request.getComment());
        return ResponseEntity.ok(review);
    }

    @GetMapping
    public ResponseEntity<List<Reviews>> getAllReviews() {
        return ResponseEntity.ok(reviewsService.getAllReviews());
    }

    @GetMapping("/{id}")
    public Optional<Reviews> getReviewById(@PathVariable long id)
    {
        return reviewsService.getReviewById(id);
    }
}
