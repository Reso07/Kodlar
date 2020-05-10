package JavaCourse;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, Location> locationMap = new HashMap<Integer, Location>();

    public static void main(String[] args) {
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



     //   int loc = 1;
     //   while(true) {
     //       System.out.println(locationMap.get(loc).getDescription());
     //       if(loc == 0) {
     //           break;
     //       }

     //       Map<String,Integer> exits = locationMap.get(loc).getExits();
     //       System.out.print("Available exits are ");
     //       for(String exit : exits.keySet()) {
     //           System.out.print(exit + " , ");
     //       }
     //       System.out.println();

     //       String direction = scanner.nextLine().toUpperCase();

     //       if(exits.containsKey(direction)) {
     //           loc = exits.get(direction);
     //       } else {
     //           System.out.println("You cannot go in that direction");
     //       }
     //   }

        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
        for(String i : road) {
            System.out.println(i);
        }

        System.out.println("===========================================================");

        String[] building = "You are inside a building, a well house for a small spring".split(", ");
        for(String i: building) {
            System.out.println(i);
        }

    }
}
