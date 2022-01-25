package ch.bbw.zork;

import org.junit.Assert;
import org.junit.Test;


public class Test_Command {

    @Test
    public void GetCommandWord_ExpectIsThere(){
        //Arrange
        Command command = new Command("South","West");

        //Act
        String getCommand = command.getCommandWord();

        //Assert
        Assert.assertEquals(getCommand, "South");
    }

    @Test
    public void getSecondWord_ExpectIsThere(){
        //Arrange
        Command command = new Command("South","West");

        //Act
        String getSecondWord = command.getSecondWord();

        //Assert
        Assert.assertEquals(getSecondWord, "West");
    }

    @Test
    public void isUnknown_ValueIsNull(){
        //Arrange
        Command command = new Command(null,"West");

        //Act
        Boolean isCommandWordThere = command.isUnknown();

        //Assert
        Assert.assertEquals(isCommandWordThere, true);
    }

    @Test
    public void hasSecondWord_ValueIsNull(){
        //Arrange
        Command command = new Command("South","West");

        //Act
        Boolean hasSecondWord = command.hasSecondWord();

        //Assert
        Assert.assertEquals(hasSecondWord, true);
    }
}
