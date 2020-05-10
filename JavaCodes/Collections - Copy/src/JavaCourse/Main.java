package JavaCourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
		Theather theather = new Theather("Ayşe", 10, 10);
		//   theather.seatNumbers();
		theather.reserveSeat("A05");
		theather.reserveSeat("A06");
		theather.reserveSeat("A06");
		List<Theather.Seat> reverse = new ArrayList<>(theather.getSeats());
		Collections.reverse(reverse);
		printList(reverse);
		Collections.shuffle(reverse);
		printList(reverse);

		List<Theather.Seat> priceSeats = new ArrayList<>(theather.getSeats());
		priceSeats.add(theather.new Seat("B01",13.00));
		priceSeats.add(theather.new Seat("A06",13.00));
		Collections.sort(priceSeats,Theather.PRICE_ORDER);
		printList(priceSeats);
	}

    private static void printList(List<Theather.Seat> list) {
    	for(Theather.Seat seat : list) {
			System.out.print(" "+seat.getSeatNumber()+" - "+seat.getPrice()+" ");
		}
		System.out.println();
		System.out.println("======================================");
	}
}
