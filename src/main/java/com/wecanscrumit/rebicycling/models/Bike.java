package com.wecanscrumit.rebicycling.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Bike {

    @Id
    @GeneratedValue
    private Long id;
    String brandName;
    String imageUrl;
    String bicycleType;
    String wheelSize;
    String donatedBy;
    String buyInPrice;
    String currentStatus;
    @ManyToOne
    private Shop shop;
    
    @JsonIgnore
    @OneToMany
    private Collection<Gender> genders;
    
    @JsonIgnore
    @ManyToOne
    private Collection<SuggestedAge> suggestedAges;

    public Long getId() {
        return id;
    }

    public String getBrandName() {
        return brandName;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    public String getBicycleType() {
        return bicycleType;
    }

    public String getWheelSize() {
        return wheelSize;
    }

    public String getDonatedBy() {
        return donatedBy;
    }

    public String getBuyInPrice() {
        return buyInPrice;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public Bike(){
    }
    
    public Bike(
            String brandName,
                String imageUrl,
                String bicycleType,
                String wheelSize,
                String donatedBy,
                String buyInPrice,
                String currentStatus,
                Shop shop,
                Gender genders,
                SuggestedAge suggestedAges
                ) {
        this.brandName = brandName;
        this.imageUrl = imageUrl;
        this.bicycleType = bicycleType;
        this.wheelSize = wheelSize;
        this.donatedBy = donatedBy;
        this.buyInPrice = buyInPrice;
        this.currentStatus = currentStatus;
        this.shop=shop;
        this.genders = new ArrayList<>(Arrays.asList(genders));
        this.suggestedAges = new ArrayList<>(Arrays.asList(suggestedAges));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bike bike = (Bike) o;
        return Objects.equals(id, bike.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
