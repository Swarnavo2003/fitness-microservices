package com.fitness.ai_service.controllers;

import com.fitness.ai_service.dto.RecommendationDTO;
import com.fitness.ai_service.services.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<RecommendationDTO>> getUserRecommendation(@PathVariable String userId) {
        return ResponseEntity.ok(recommendationService.getUserRecommendation(userId));
    }

    @GetMapping("/activity/{activityId}")
    public ResponseEntity<RecommendationDTO> getActivityRecommendation(@PathVariable String activityId) {
        return ResponseEntity.ok(recommendationService.getActivityRecommendation(activityId));
    }
}
