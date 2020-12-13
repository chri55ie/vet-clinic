package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

public class Dog {
    private final String name;
    private final String breed;
    private final String colour;
    private final LocalDateTime doB;
    private final String favouriteFood;
    private final String favouriteToy;

    // public Dog(String name, String breed, String colour, LocalDateTime doB) {

      //  this (name, breed, colour, doB);

       /* \\above or below
        this.name = name;
        this.breed = breed;
        this.doB = doB;
        this.favouriteFood = null; */
    //}

    public Dog(String name, String breed, String colour, LocalDateTime doB, String favouriteFood, String favouriteToy) {
        this.name = name;
        this.breed = breed;
        this.colour = colour;
        this.doB = doB;
        this.favouriteFood = favouriteFood;
        this.favouriteToy = favouriteToy;
    }



    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public String getColour() { return colour; }

    public LocalDateTime getDoB() {

        return doB;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }

    public String getFavouriteToy() { return favouriteToy; }




}
