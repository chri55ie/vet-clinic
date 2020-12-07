package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {
    private final String name;
    private final String breed;
    private final LocalDateTime doB;
    private final String favouriteFood;

    public Dog(String name, String breed, LocalDateTime doB) {

        this (name, breed, doB, null);

       /* \\above or below
        this.name = name;
        this.breed = breed;
        this.doB = doB;
        this.favouriteFood = null; */
    }

    public Dog(String name, String breed, LocalDateTime doB, String favouriteFood) {
        this.name = name;
        this.breed = breed;
        this.doB = doB;
        this.favouriteFood = favouriteFood;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDateTime getDoB() {

        return doB;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }
}
