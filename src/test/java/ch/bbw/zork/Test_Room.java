package ch.bbw.zork;

import org.junit.Assert;
import org.junit.Test;

public class Test_Room {
    @Test
    public void putTest() {
      //Arrange & Act
        Room outside, lab, tavern, gblock, office, secretRoom, bedroom;

        outside = new Room("outside G block on Peninsula campus");
        lab = new Room("lab, a lecture theatre in A block");
        tavern = new Room("the Seahorse Tavern (the campus pub)");
        gblock = new Room("the G Block");
        office = new Room("the computing admin office");
        secretRoom = new Room("̶t̶̶h̶̶e̶̶ ̶̶s̶̶e̶̶c̶̶r̶̶e̶̶t̶̶ ̶̶r̶̶o̶̶o̶̶m̶");
        bedroom = new Room("the bedroom");

        outside.put(null, lab, gblock, tavern);
        lab.put(null, null, null, outside);
        tavern.put(null, outside, bedroom, null);
        gblock.put(outside, office, null, bedroom);
        office.put(null, null, secretRoom, gblock);
        secretRoom.put(office, null, null, null);
        bedroom.put(tavern, gblock, null, null);

      //Assert
        Assert.assertEquals("lab, a lecture theatre in A block", outside.nextRoom("east").shortDescription());
    }
}
