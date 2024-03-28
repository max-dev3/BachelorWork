package com.example.bachelorwork.service;

import com.example.bachelorwork.model.PerformanceReview;
import com.example.bachelorwork.repository.PerformanceReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PerformanceReviewService {

    private final PerformanceReviewRepository performanceReviewRepository;

    @Autowired
    public PerformanceReviewService(PerformanceReviewRepository performanceReviewRepository) {
        this.performanceReviewRepository = performanceReviewRepository;
    }

    public List<PerformanceReview> getAllReviews() {
        return performanceReviewRepository.findAll();
    }

    public Optional<PerformanceReview> getReviewById(Long id) {
        return performanceReviewRepository.findById(id);
    }

    public PerformanceReview createReview(PerformanceReview review) {
        return performanceReviewRepository.save(review);
    }

    public PerformanceReview updateReview(Long id, PerformanceReview reviewDetails) {
        PerformanceReview review = performanceReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Performance Review not found with id " + id));

        review.setComments(reviewDetails.getComments());
        review.setRating(reviewDetails.getRating());
        review.setReviewDate(reviewDetails.getReviewDate());

        return performanceReviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        PerformanceReview review = performanceReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Performance Review not found with id " + id));

        performanceReviewRepository.delete(review);
    }
}
