package serenitylabs.tutorials.vetclinic.domain;

public class Bird {


    private static String name;
    private String colour;
    private String gender;
    private String type;

    public Bird(String name, String colour, String gender, String type) {

        this.name = name;
        this.colour = colour;
        this.gender = gender;
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public static birdBuilder called(String name) {
        return new birdBuilder(name);
    }

    public static class birdBuilder {
        private final String name;
        private String type;
        private String colour;
        private String gender;

        public birdBuilder(String name) {
            this.name = name;
        }

        public birdBuilder ofColour(String colour) {
            this.colour = colour;
            return this;
        }

        public birdBuilder ofGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Bird ofType(String type) {
            return new Bird(name,colour,gender,type);
        }


    }
}
