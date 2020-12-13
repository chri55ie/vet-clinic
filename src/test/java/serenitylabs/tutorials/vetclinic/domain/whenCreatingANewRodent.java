package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class whenCreatingANewRodent {


    @Test
    public void createARodent() {

        Rodent henry = Rodent.called("Henry").ofType("Hamster").ofColour("Brown");

        Assert.assertEquals("Henry", henry.getName());
        Assert.assertEquals("Hamster", henry.getType());
        Assert.assertEquals("Brown", henry.getColour());

    }

}