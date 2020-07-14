package com.wecanscrumit.rebicycling.repositories;

import com.wecanscrumit.rebicycling.models.Gender;
import com.wecanscrumit.rebicycling.models.SuggestedAge;
import org.springframework.data.repository.CrudRepository;

public interface SuggestedAgeRepository extends CrudRepository<SuggestedAge, Long> {
}
