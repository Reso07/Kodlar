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

        int loc = 1;
        while(true) {
            System.out.println(locationMap.get(loc).getDescription());
            if(loc == 0) {
                break;
            }
            loc = scanner.nextInt();
            if(!locationMap.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }
        }



    }
}
