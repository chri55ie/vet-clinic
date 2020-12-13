package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

public class whenCreatingANewBird {

    @Test
    public void createABird(){

        Bird tweety = Bird.called("Tweety").ofColour("Yellow").ofGender("Female").ofType("Budgie");

        Assert.assertEquals("Tweety", tweety.getName());
        Assert.assertEquals("Yellow", tweety.getColour());
        Assert.assertEquals("Female", tweety.getGender());
        Assert.assertEquals("Budgie", tweety.getType());

    }
}
