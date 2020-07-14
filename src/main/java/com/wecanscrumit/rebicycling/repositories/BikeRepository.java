package com.wecanscrumit.rebicycling.repositories;

import com.wecanscrumit.rebicycling.models.Bike;
import org.springframework.data.repository.CrudRepository;

public interface  BikeRepository  extends CrudRepository<Bike,Long> {
}
