package com.fitness.activity_service.repositories;

import com.fitness.activity_service.models.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ActivityRepository extends MongoRepository<Activity, String> {
}
