package com.wecanscrumit.rebicycling;

import com.wecanscrumit.rebicycling.models.Bike;
import com.wecanscrumit.rebicycling.models.Gender;
import com.wecanscrumit.rebicycling.models.Shop;
import com.wecanscrumit.rebicycling.models.SuggestedAge;
import com.wecanscrumit.rebicycling.repositories.BikeRepository;
import com.wecanscrumit.rebicycling.repositories.GenderRepository;
import com.wecanscrumit.rebicycling.repositories.ShopRepository;
import com.wecanscrumit.rebicycling.repositories.SuggestedAgeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

@DataJpaTest
public class JPAWiringTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ShopRepository shopRepo;

    @Autowired
    private GenderRepository genderRepo;

    @Autowired
    private SuggestedAgeRepository suggestedAgeRepo;

    @Autowired
    private BikeRepository bikeRepo;


    @Test
    public void shopShouldHaveaListOfBikes(){
        Shop testShop = new Shop("Columbus");
        Gender testGenderMale = new Gender("Male");
        Gender testGenderFemale = new Gender("Female");
        SuggestedAge testSuggestedAge = new SuggestedAge ("2-4");
        SuggestedAge testSuggestedAge2 = new SuggestedAge ("5-7");
        Bike testBike = new Bike (
                "Brando",
                "image",
                "Mountain",
                "12",
                "Frank Swanson",
                "$100.00",
                "Available",
                testShop,
                testGenderFemale,
                testSuggestedAge
                );
        shopRepo.save(testShop);
        genderRepo.save(testGenderFemale);
        genderRepo.save(testGenderMale);
        suggestedAgeRepo.save(testSuggestedAge);
        suggestedAgeRepo.save(testSuggestedAge2);
        bikeRepo.save(testBike);

        entityManager.flush();
        entityManager.clear();

        Optional<Shop> retrievedShopOpt = shopRepo.findById(testShop.getId());


    }
}
