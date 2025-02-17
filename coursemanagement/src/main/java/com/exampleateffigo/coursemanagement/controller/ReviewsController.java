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
@RequestMapping
public class ReviewsController {

    @Autowired
    private ReviewsService reviewsService;

    @PostMapping("/auth/user/api/reviews/add-review")
    public ResponseEntity<ReviewResponseDTO> addReview(@RequestBody ReviewRequestDTO request) {
        ReviewResponseDTO reviewResponseDTO = reviewsService.addReview(request);
        return ResponseEntity.ok(reviewResponseDTO);
    }

    @GetMapping({"/auth/admin/api/reviews/get-all-reviews", "/auth/user/api/reviews/get-all-reviews"})
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews() {
        return ResponseEntity.ok(reviewsService.getAllReviews());
    }

    @GetMapping("/auth/admin/api/reviews/get-review/{id}")
    public ResponseEntity<ReviewResponseDTO> getReviewById(@PathVariable long id)
    {
        return ResponseEntity.ok(reviewsService.getReviewById(id));
    }

    @PutMapping("/auth/user/api/reviews/update-review/{id}")
    public ResponseEntity<ReviewResponseDTO> updateReview(@PathVariable long id, @RequestBody ReviewRequestDTO reviewRequestDTO)
    {
        return ResponseEntity.ok(reviewsService.updateReview(id, reviewRequestDTO));
    }

    @DeleteMapping("/auth/admin/api/reviews/delete-review/{id}")
    public ResponseEntity<String> deleteReview(@PathVariable long id) {
        reviewsService.deleteReview(id);
        return ResponseEntity.ok("Review deleted successfully.");
    }
}
