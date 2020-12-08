package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewCat {


    @Test
    public void createACat(){

        LocalDateTime birthday = LocalDateTime.now();

        Cat felix = Cat.called("Felix")
                .ofType("Tabby")
                .bornON(birthday);

        Assert.assertEquals("Felix", felix.getName());
        Assert.assertEquals("Tabby", felix.getBreed());
        Assert.assertEquals(birthday, felix.getBirthday());





    }


}
