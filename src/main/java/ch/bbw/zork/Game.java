package ch.bbw.zork;import java.util.ArrayList;import java.util.HashSet;import java.util.Stack;public class Game {    private Parser parser;    private Room currentRoom;    private Room outside, lab, tavern, gblock, office, secretRoom, bedroom;    private Item item1, item2;    private ArrayList<Room> map;    private HashSet<Item> bp;    private Stack<Room> previousRooms;    public Game() {        parser = new Parser();        // Create all the rooms and link their exits together.        outside = new Room("outside G block on Peninsula campus");        lab = new Room("lab, a lecture theatre in A block");        tavern = new Room("the Seahorse Tavern (the campus pub)");        gblock = new Room("the G Block");        office = new Room("the computing admin office");        secretRoom = new Room("this is the final secret room");        bedroom = new Room("the bedroom");        // initialise room exits        outside.put(null, lab, gblock, tavern);        lab.put(null, null, null, outside);        tavern.put(null, outside, null, null);        gblock.put(outside, office, null, null);        office.put(null, null, null, gblock);        secretRoom.put(office, null, null, null);        bedroom.put(tavern, gblock, null, null);        currentRoom = outside;        previousRooms = new Stack<>();        map = new ArrayList<>();        map.add(outside);        map.add(lab);        map.add(tavern);        map.add(gblock);        map.add(office);        map.add(secretRoom);        map.add(bedroom);        item1 = new Item();        item1.setName("Hammer");        item1.setWeight(1);        item2 = new Item();        item2.setName("Key");        item2.setWeight(1);        lab.add(item1);        lab.add(item2);        bp = new HashSet<>();    }    public void play() {        printWelcome();        boolean finished = false;        while (!finished) {            Command command = parser.get(); // reads a command            finished = processCommand(command);        }        System.out.println("Thank you for playing.  Good bye.");    }    private void printWelcome() {        System.out.println();        System.out.println("Welcome to Zork!");        System.out.println("Zork is a simple adventure game.");        System.out.println("Type 'help' if you need help.");        System.out.println();        System.out.println(currentRoom.longDescription());    }    private boolean processCommand(Command command) {        if (command.isUnknown()) {            System.out.println("I don't know what you mean...");            return false;        }        String commandWord = command.getCommandWord();        if (commandWord.equals("help")) {            printHelp();        } else if (commandWord.equals("go")) {            goRoom(command);            if (currentRoom == secretRoom) {                System.out.println("Sie sind in der Taverne und haben gewonnen!");                return true;            }        } else if (commandWord.equals("map")) {            System.out.println("Map (all rooms)");            System.out.println("---------------");            for (Room room : map) {                System.out.print("- ");                if (room == currentRoom) {                    System.out.print(">>> ");                }                System.out.println(room.shortDescription());            }        } else if (commandWord.equals("get")) {            if (command.hasSecondWord()) {                Item item = currentRoom.getItem(command.getSecondWord());                bp.add(item);            }        } else if (commandWord.equals("put")) {            Item itemToPut = null;            for (Item item : bp) {                if (item.getName().equals(command.getSecondWord())) {                    itemToPut = item;                    break;                }            }            if (itemToPut != null) {                currentRoom.add(itemToPut);                bp.remove(itemToPut);            }        } else if (commandWord.equals("show")) {            System.out.println("Backpack content");            System.out.println("----------------");            for (Item item : bp)                System.out.println("- " + item.getName());        } else if (commandWord.equals("back")) {            if (!previousRooms.isEmpty()) {                currentRoom = previousRooms.pop();                System.out.println(currentRoom.longDescription());            } else                System.out.println("Don't know where to go :(");        } else if (commandWord.equals("quit")) {            if (command.hasSecondWord())                System.out.println("Quit what?");            else                return true;        }        return false;    }    private void printHelp() {        System.out.println("You are lost. You are alone. You wander");        System.out.println("around at Monash Uni, Peninsula Campus.");        System.out.println();        System.out.println("Your command words are:");        System.out.println(parser.showCommands());    }    private void goRoom(Command command) {        if (!command.hasSecondWord()) {            System.out.println("Go where?");        } else {            String direction = command.getSecondWord();            Room nextRoom = currentRoom.nextRoom(direction);            if (nextRoom == null)                System.out.println("There is no door!");            else {                previousRooms.push(currentRoom);                currentRoom = nextRoom;                System.out.println(currentRoom.longDescription());            }        }    }}