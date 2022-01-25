package ch.bbw.zork;

import org.junit.Assert;
import org.junit.Test;

public class Test_CommandWords {

    @Test
    public void testAllCommandWords() {
        // Arrange
        CommandWords cmdWords = new CommandWords();

        // Act
        String allCmd = cmdWords.showAll();

        // Assert
        Assert.assertEquals("go  quit  help  back  map  get  put  show  ", allCmd);
    }

    @Test
    public void testIsCommand() {
        // Arrange
        CommandWords cmdWords = new CommandWords();

        // Act
        String allCmd = cmdWords.showAll();

        // Assert
        Assert.assertTrue(cmdWords.isCommand("go"));
    }
}
