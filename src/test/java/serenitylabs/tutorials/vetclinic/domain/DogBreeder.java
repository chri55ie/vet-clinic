package serenitylabs.tutorials.vetclinic.domain;

import java.time.LocalDateTime;

//WithBreed interface class called first, then the method within calls DogBuilder
public class DogBreeder implements WithBreed, WithColour{
        private String name;
        private String breed;
        private String colour;
        private String favouriteFood;
        private String favouriteToy;
        private LocalDateTime birthday;

        public static DogBreeder aDog(){
            return new DogBreeder();
        }

    public static DogBreeder aLargeDog() {
            return aDog().ofBreed("Labrador");

    }

    public static DogBreeder aSmallDog() {
        return aDog().ofBreed("Poodle");
    }

    public static DogBreeder aGuardDog() {
        return aDog().ofBreed("GuardDog");
    }

    public DogBreeder called(String name) {
            this.name = name;
            return this;
        }


        public DogBreeder ofBreed(String breed) {
            this.breed = breed;
            return this;
        }

        public DogBreeder ofColour(String colour) {
            this.colour = colour;
            return this;
        }

        public DogBreeder bornOnBirthday(LocalDateTime birthday) {

            this.birthday = birthday;
            return this;
        }

        public DogBreeder withFavouriteFood(String favouriteFood) {
            this.favouriteFood = favouriteFood;
            return this;
        }

        public Dog withFavouriteToy(String favouriteToy) {
            return new Dog(name,breed,colour,birthday, favouriteFood, favouriteToy);
        }

    }

