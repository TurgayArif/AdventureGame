package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    /*
    Implement the command() method in the Main class to allow players to type full words, or phrases, then move to the correct location based upon their input.
    The player should be able to type commands such as "Go West", "run South", "I need to Quit this game" or
    just "East" and the program will move to the appropriate location if there is one.
    The console should display its current location, then it should prompt the user with: "Available exits are ", and its available exits. For example:
    You are standing at the end of a road before a small brick building
    Available exits are Q, S, E, N, W,
    A move in a valid direction should print (keep in mind N, S, E and W variants - showing N below):
    You are standing at the end of a road before a small brick building
    Available exits are Q, S, E, N, W,
    You are in the forest
    Available exits are Q, S, W,
    An attempt to move in an invalid direction should print a message and remain in the same place.
    The printed message should be: "You cannot go in that direction". For Example:
    You are standing at the end of a road before a small brick building
    Available exits are Q, S, E, N, W,
    You cannot go in that direction
    You are standing at the end of a road before a small brick building
    Available exits are Q, S, E, N, W,
    Output for quit (Q) command should be displayed as:
    You are standing at the end of a road before a small brick building
    Available exits are Q, S, E, N, W,
    You are sitting in front of a computer learning Java
    Single letter commands (N, W, S, E, Q) should still be available.
    TIP: Declare a Map called vocabulary as a field with private access modifier, the object is of type HashMap.
    Create its key-value pair in the constructor by using the put() method. Both key and value are of type String.
    Use vocabulary to store the original commands aliases (eg. NORTH = N, SOUTH = S, ...).
    TIP: Instantiate (create) the Scanner object inside the method.
    NOTE: Ignore "No line found" in the output if you get an error message. It is not the reason for the error. Instead, check spelling/spaces/format in the printed message.
*/

/*
    Only add/edit code where it is stated in the description.
*/

    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));
        command();
    }

    public static void command() {
        Map<String, String> vocabulary = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        vocabulary.put("QUIT", "Q");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("NORTH", "N");

        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = new HashMap<>(locations.get(loc).getExits());
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }

            String direction = sc.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}


