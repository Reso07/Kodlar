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
        Seat requested = new Seat(seatNum);
        int foundSeat = Collections.binarySearch(seats, requested,null);
        if(foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        }
        System.out.println("There is no seat " + seatNum);
        return false;
    }

    public String getName() { return name; }

    public void seatNumbers() {
        for(Seat s : seats) {
            System.out.println(s.getSeatNumber());
        }
    }

    private class Seat implements Comparable<Seat> {
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

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
