package serenitylabs.tutorials.vetclinic.domain;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;

public class WhenCreatingANewDog {

    /**@Test //DEFAULT CONSTRUCTOR USING SETTERS
    public void itShouldHaveAName() throws Exception {
        Dog fido = new Dog();
        LocalDateTime birthday = LocalDateTime.now();

        fido.setName("Fido");
        fido.setBreed("Poodle");
        fido.setDoB(birthday);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals(birthday, fido.getDoB());

    } **/

    @Test //DEFAULT CONSTRUCTOR USING PARAMETERS
    public void itShouldHaveAName() throws Exception {

        LocalDateTime birthday = LocalDateTime.now();

        Dog fido = new Dog("Fido", "Poodle", birthday);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals(birthday, fido.getDoB());
    }

    @Test //DEFAULT CONSTRUCTOR USING PARAMETERS plus OPTIONAL FIELD PIZZA
        public void itShouldHaveAFavouriteFood() throws Exception {

            LocalDateTime birthday = LocalDateTime.now();

            Dog fido = new Dog("Fido", "Poodle", birthday, "Pizza");

            Assert.assertEquals("Fido", fido.getName());
            Assert.assertEquals("Poodle", fido.getBreed());
            Assert.assertEquals(birthday, fido.getDoB());
            Assert.assertEquals("Pizza", fido.getFavouriteFood());


    }
}
