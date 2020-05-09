package JavaCourse;

import java.util.*;

public class Theather {
    private final String name;
    private List<Seat> seats = new ArrayList<>();

    public Theather(String name, int numberOfRows, int seatPerRow) {
        this.name = name;

        for(char row = 'A'; row<'A' + (numberOfRows - 1); row++) {
            for(int seatNumber = 1; seatNumber <= seatPerRow; seatNumber++) {
                seats.add(new Seat(row + String.format("%02d",seatNumber)));
            }
        }
    }

    public boolean reserveSeat(String seatNum) {
        Seat requested = null;
        for(Seat s : seats) {
            if(s.getSeatNumber().equals(seatNum)) {
                requested = s;
                break;
            }
        }
        if(requested == null) {
            System.out.println("There is no "+seatNum);
            return false;
        }
        return requested.reserve();
    }

    public String getName() { return name; }

    public void seatNumbers() {
        for(Seat s : seats) {
            System.out.println(s.getSeatNumber());
        }
    }

    private class Seat {
        private final String seatNumber;
        private boolean isReserved = false;

        public Seat(String seatNumber) { this.seatNumber = seatNumber; }

        public boolean reserve() {
            if(!isReserved) {
                isReserved = true;
                System.out.println("Reserved " + seatNumber);
                return true;
            }
            System.out.println(seatNumber + " has already been reserved.");
            return false;
        }

        public void cancel() {
            if(isReserved) {
                isReserved = false;
                System.out.println("Cancelled " + seatNumber);
            } else {
                System.out.println(seatNumber + " is not even reserved.");
            }
        }

        public String getSeatNumber() { return seatNumber; }
    }
}
