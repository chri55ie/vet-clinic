package serenitylabs.tutorials.vetclinic.domain;

import org.assertj.core.api.AssertDelegateTarget;
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

   /** @Test //DEFAULT CONSTRUCTOR USING PARAMETERS
    public void itShouldHaveAName() throws Exception {

        LocalDateTime birthday = LocalDateTime.now();

        Dog fido = new Dog("Fido", "Poodle", birthday);

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals(birthday, fido.getDoB());
    }**/

   /**@Test //BUILDER PATTERN
   public void itShouldHaveAName() throws Exception {
       LocalDateTime birthday = LocalDateTime.now();

       Dog fido = Dog.called("Fido")
               .ofBreed("Poodle")
               .bornOnBirthday(birthday);


       Assert.assertEquals("Fido", fido.getName());
       Assert.assertEquals("Poodle", fido.getBreed());
       Assert.assertEquals(birthday, fido.getDoB());
       //Assert.assertEquals("Pizza", fido.getFavouriteFood());

   }**/

  /** @Test
    public void a_dog_can_have_an_mandatory_colour(){

       LocalDateTime birthday = LocalDateTime.now();

       Dog fido = Dog.called("Fido")
               .ofBreed("Labrador")
               .ofColour("Black")
               .bornOnBirthday(birthday);


       Assert.assertEquals("Fido", fido.getName());
       Assert.assertEquals("Labrador", fido.getBreed());
       Assert.assertEquals("Black", fido.getColour());
       Assert.assertEquals(birthday, fido.getDoB());

   }**/

    @Test
    public void a_dog_can_have_an_optional_Favourite_Food(){

        LocalDateTime birthday = LocalDateTime.now();

        Dog fido = DogBreeder.aLargeDog()
                .called("Fido")
                .ofColour("black")
                .bornOnBirthday(birthday)
                .withFavouriteFood("Pizza")
                .withFavouriteToy("Ball");

        Assert.assertEquals("Fido", fido.getName());
        Assert.assertEquals("Labrador", fido.getBreed());
        Assert.assertEquals("black", fido.getColour());
        Assert.assertEquals(birthday, fido.getDoB());
        Assert.assertEquals("Pizza", fido.getFavouriteFood());
        Assert.assertEquals("Ball", fido.getFavouriteToy());

    }


    @Test
    public void create_a_small_dog() {

        LocalDateTime birthday = LocalDateTime.now();

        Dog fido = DogBreeder.aSmallDog()
                .called("Spot")
                .ofColour("black")
                .bornOnBirthday(birthday)
                .withFavouriteFood("Pizza")
                .withFavouriteToy("Ball");

        Assert.assertEquals("Spot", fido.getName());
        Assert.assertEquals("Poodle", fido.getBreed());
        Assert.assertEquals("black", fido.getColour());
        Assert.assertEquals(birthday, fido.getDoB());
        Assert.assertEquals("Pizza", fido.getFavouriteFood());
        Assert.assertEquals("Ball", fido.getFavouriteToy());
    }

        @Test
        public void create_a_guard_dog(){

            LocalDateTime birthday = LocalDateTime.now();

            Dog fido = DogBreeder.aGuardDog()
                    .called("Spot")
                    .ofColour("black")
                    .bornOnBirthday(birthday)
                    .withFavouriteFood("Pizza")
                    .withFavouriteToy("Ball");

            Assert.assertEquals("Spot", fido.getName());
            Assert.assertEquals("GuardDog", fido.getBreed());
            Assert.assertEquals("black", fido.getColour());
            Assert.assertEquals(birthday, fido.getDoB());
            Assert.assertEquals("Pizza", fido.getFavouriteFood());
            Assert.assertEquals("Ball", fido.getFavouriteToy());
    }






    /*@Test //DEFAULT CONSTRUCTOR USING PARAMETERS plus OPTIONAL FIELD PIZZA
        public void itShouldHaveAFavouriteFood() throws Exception {

            LocalDateTime birthday = LocalDateTime.now();

            Dog fido = new Dog("Fido", "Poodle", birthday, "Pizza");

            Assert.assertEquals("Fido", fido.getName());
            Assert.assertEquals("Poodle", fido.getBreed());
            Assert.assertEquals(birthday, fido.getDoB());
            Assert.assertEquals("Pizza", fido.getFavouriteFood());


    }*/
}
