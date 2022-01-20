package ch.bbw.zork;

import org.junit.Assert;
import org.junit.Test;

public class Test_Item {

    @Test
    public void setGetName_ExpectNameThere_(){
        // Arrange
        Item item = new Item();
        // Act
        item.setName("Ball");
        // Assert
        Assert.assertEquals("Ball", item.getName());
    }

    @Test
    public void setGetDescription_ExpectDescriptionThere_(){
        // Arrange
        Item item = new Item();
        // Act
        item.setDescription("Rund");
        // Assert
        Assert.assertEquals("Rund", item.getDescription());
    }

    @Test
    public void setGetWeight_ExpectWeightThere_(){
        // Arrange
        Item item = new Item();
        // Act
        item.setWeight(1);
        // Assert
        Assert.assertEquals(1, item.getWeight());
    }

}
