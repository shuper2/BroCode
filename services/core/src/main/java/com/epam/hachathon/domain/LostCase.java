package com.epam.hachathon.domain;

import java.time.ZonedDateTime;

public final class LostCase {
    private final long id;
    private final String userId;
    private final ZonedDateTime lostTime;
    private final String country;
    private final String city;
    private final int age;
    private final Gender gender;
    private final String imageUrl;
    private int highestProbability = 0;

    public LostCase(final long id,
                    final String userId,
                    final ZonedDateTime lostTime,
                    final String country,
                    final String city,
                    final int age,
                    final Gender gender,
                    final String imageUrl) {
        this.id = id;
        this.userId = userId;
        this.lostTime = lostTime;
        this.country = country;
        this.city = city;
        this.age = age;
        this.gender = gender;
        this.imageUrl = imageUrl;
    }

    public long getId() {
        return id;
    }
    public String getUserId() {
        return userId;
    }
    public ZonedDateTime getLostTime() {
        return lostTime;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public int getAge() {
        return age;
    }
    public Gender getGender() {
        return gender;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public int getHighestProbability() {
        return highestProbability;
    }
    public void setHighestProbability(final int highestProbability) {
        this.highestProbability = highestProbability;
    }
}
