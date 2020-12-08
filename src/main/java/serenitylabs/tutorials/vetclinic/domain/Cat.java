package serenitylabs.tutorials.vetclinic.domain;



import java.time.LocalDateTime;

public class Cat {

    private String name;
    private String breed;
    private LocalDateTime birthday;

    public Cat(String name, String breed, LocalDateTime birthday) {
        this.name = name;
        this.breed = breed;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public static catBuilder called(String name) {
        return new catBuilder(name);
    }

    public static class catBuilder {

        private final String name;
        private String breed;

        public catBuilder(String name) {
            this.name = name;
        }

        public catBuilder ofType(String breed) {
            this.breed = breed;
            return this;
        }

        public Cat bornON(LocalDateTime birthday) {
            return new Cat(name, breed, birthday);
        }
    }
}
