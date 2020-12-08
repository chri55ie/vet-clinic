package serenitylabs.tutorials.vetclinic.domain;

import java.security.cert.CertPathBuilder;
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



    public static DogBuilder called(String name) {
        return new DogBuilder(name);
    }

    public static class DogBuilder {
        private String name;
        private String breed;

        public DogBuilder(String name) {
            this.name = name;
        }

        public DogBuilder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public Dog bornOnBirthday(LocalDateTime birthday) {
            return new Dog(name,breed,birthday);
        }




    }
}
