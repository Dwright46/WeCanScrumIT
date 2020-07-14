package com.wecanscrumit.rebicycling.repositories;

import com.wecanscrumit.rebicycling.models.Gender;
import org.springframework.data.repository.CrudRepository;

public  interface GenderRepository extends CrudRepository<Gender, Long> {

}
