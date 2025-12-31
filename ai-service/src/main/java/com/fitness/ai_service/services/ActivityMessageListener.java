package com.fitness.ai_service.services;

import com.fitness.ai_service.models.Activity;
import com.fitness.ai_service.models.Recommendation;
import com.fitness.ai_service.repositories.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityMessageListener {

    private final ActivityAIService activityAIService;

    private final RecommendationRepository recommendationRepository;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "activity-processor-group")
    public void processActivity(Activity activity) {
        log.info("Received Activity for processing: {}", activity.getUserId());
        Recommendation recommendation = activityAIService.generateRecommendation(activity);
        Recommendation savedRecommendation = recommendationRepository.save(recommendation).block();
        log.info("Saved Recommendation is {}", savedRecommendation);
    }
}
