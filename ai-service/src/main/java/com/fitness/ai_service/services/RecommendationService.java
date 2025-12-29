package com.fitness.ai_service.services;

import com.fitness.ai_service.dto.RecommendationDTO;
import com.fitness.ai_service.models.Recommendation;
import com.fitness.ai_service.repositories.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public List<RecommendationDTO> getUserRecommendation(String userId) {
        List<Recommendation> recommendations = recommendationRepository.findByUserId(userId);
        List<RecommendationDTO> recommendationDTOS = recommendations.stream()
                .map(recommendation -> RecommendationDTO.builder()
                        .id(recommendation.getId())
                        .activityId(recommendation.getActivityId())
                        .userId(recommendation.getUserId())
                        .recommendation(recommendation.getRecommendation())
                        .improvements(recommendation.getImprovements())
                        .safety(recommendation.getSuggestions())
                        .suggestions(recommendation.getSuggestions())
                        .createdAt(recommendation.getCreatedAt())
                        .updatedAt(recommendation.getUpdatedAt())
                        .build())
                .toList();
        return recommendationDTOS;
    }

    public RecommendationDTO getActivityRecommendation(String activityId) {
        Recommendation recommendation = recommendationRepository.findByActivityId(activityId)
                .orElseThrow(() -> new RuntimeException("No recommendation found"));
        return RecommendationDTO.builder()
                .id(recommendation.getId())
                .activityId(recommendation.getActivityId())
                .userId(recommendation.getUserId())
                .recommendation(recommendation.getRecommendation())
                .improvements(recommendation.getImprovements())
                .safety(recommendation.getSuggestions())
                .suggestions(recommendation.getSuggestions())
                .createdAt(recommendation.getCreatedAt())
                .updatedAt(recommendation.getUpdatedAt())
                .build();
    }
}
