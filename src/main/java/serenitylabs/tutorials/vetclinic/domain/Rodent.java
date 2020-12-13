package serenitylabs.tutorials.vetclinic.domain;

import java.lang.reflect.Type;

public class Rodent {
    private String name;
    private String type;
    private String colour;

    public Rodent (String name, String type, String colour){
        this.name = name;
        this.type = type;
        this.colour = colour;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public String getColour(){
        return colour;
    }

    public static rodentBuilder called(String name) {
        return new rodentBuilder(name);
    }

    public static class rodentBuilder {
        private final String name;
        private String type;

        public rodentBuilder(String name) {
            this.name = name;
        }

        public rodentBuilder ofType(String type) {
            this.type = type;
            return this;
        }

        public Rodent ofColour(String colour) {
            return new Rodent(name, type, colour);
        }
    }
}
