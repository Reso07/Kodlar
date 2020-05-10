package com.wizard;

import Location.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locationMap = new HashMap<Integer, Location>();

    public static void main(String[] args) {
        // Change the program to allow players to type full words, or phrases, then move to the
        // correct location based upon their input.
        // The player should be able to type commands such as "Go West", "run South", or just "East"
        // and the program will move to the appropriate location if there is one.  As at present, an
        // attempt to move in an invalid direction should print a message and remain in the same place.
        //
        // Single letter commands (N, W, S, E, Q) should still be available.

        Scanner scanner = new Scanner(System.in);

        locationMap.put(0,new Location(0,"You are in front of a computer learning Java"));
        locationMap.put(1,new Location(1,"You are standing at the end of a road before a small brick building"));
        locationMap.put(2,new Location(2,"You are at the top of a hill"));
        locationMap.put(3,new Location(3,"You are inside a building"));
        locationMap.put(4,new Location(4,"You are in a valley beside a stream"));
        locationMap.put(5, new Location(5,"You are by the sea shore"));

        locationMap.get(1).addExit("W",2);
        locationMap.get(1).addExit("E",3);
        locationMap.get(1).addExit("S",4);
        locationMap.get(1).addExit("N",5);

        locationMap.get(2).addExit("N",5);

        locationMap.get(3).addExit("W",1);

        locationMap.get(4).addExit("N",1);
        locationMap.get(4).addExit("W",2);

        locationMap.get(5).addExit("S",1);
        locationMap.get(5).addExit("W",2);

        Map<String,String> commands = new HashMap<>();
        commands.put("WEST","W");
        commands.put("EAST","E");
        commands.put("SOUTH","S");
        commands.put("NORTH","N");
        commands.put("QUIT","Q");


       int loc = 1;
       while(true) {
           System.out.println(locationMap.get(loc).getDescription());
           if(loc == 0) {
               break;
           }

           Map<String,Integer> exits = locationMap.get(loc).getExits();
           System.out.print("Available exits are ");
           for(String exit : exits.keySet()) {
               System.out.print(exit + " , ");
           }
           System.out.println();

           String direction = scanner.nextLine().toUpperCase();
           if(direction.length() > 1) {
               String[] words = direction.split(" ");
               for(String i: words) {
                   if(commands.containsKey(i)) {
                       direction = commands.get(i);
                       break;
                   }
               }
           }


           if(exits.containsKey(direction)) {
               loc = exits.get(direction);
           } else {
               System.out.println("You cannot go in that direction");
           }
        }
    }
}
