package JavaCourse;

import java.util.*;

public class Theather {
    private final String name;
    private List<Seat> seats = new LinkedList<>();

    static final Comparator<Seat> PRICE_ORDER = new Comparator<Seat>() {
        @Override
        public int compare(Seat s1, Seat s2) {
            if(s1.getPrice() < s2.getPrice()) {
                return -1;
            } else if(s1.getPrice() > s2.getPrice()) {
                return 1;
            } else {
                return 0;
            }
        }
    };

    public Theather(String name, int numberOfRows, int seatPerRow) {
        this.name = name;

        for(char row = 'A'; row<'A' + (numberOfRows - 1); row++) {
            for(int seatNumber = 1; seatNumber <= seatPerRow; seatNumber++) {
                double price = 12.00;
                if(row < 'D' && seatNumber >= 4 && seatNumber <= 9)  {
                    price = 14.00;
                } else if(row > 'F' || seatNumber < 4 || seatNumber >9) {
                    price = 7.00;
                }
                seats.add(new Seat(row + String.format("%02d",seatNumber),price));
            }
        }
    }

    public boolean reserveSeat(String seatNum) {
        Seat requested = new Seat(seatNum,0);
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

    public Collection<Seat> getSeats() {
        return seats;
    }

    protected class Seat implements Comparable<Seat> {
        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
        private double price;
        private final String seatNumber;
        private boolean isReserved = false;

        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber; this.price = price;
        }

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
        public double getPrice() {
            return price;
        }
    }
}
