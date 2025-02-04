package com.exampleateffigo.coursemanagement.controller;

import com.exampleateffigo.coursemanagement.dto.ReviewRequestDTO;
import com.exampleateffigo.coursemanagement.dto.ReviewResponseDTO;
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
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody ReviewRequestDTO request) {
        ReviewResponseDTO reviewResponseDTO = reviewsService.addReview(request);
        return ResponseEntity.ok(reviewResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewsService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponseDTO> getReviewById(@PathVariable long id)
    {
        return ResponseEntity.ok(reviewsService.getReviewById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable long id) {
        reviewsService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully.");
    }
}
