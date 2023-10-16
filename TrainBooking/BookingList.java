package TrainBooking;

import java.util.Collections;
import java.util.LinkedList;

public class BookingList {

    LinkedList<Booking> list = new LinkedList<>();

    public void inputData() {
        Booking booking = new Booking();
        booking.createBooking();
        list.addLast(booking);
    }

    public void displayBookingData() {
        for (Booking x : list) {
            System.out.println(x.getCcode() + ", " + x.getTcode() + ", " + x.getSeat());
        }
    }

    public void sort() {
        Collections.sort(list, (Booking b1, Booking b2) -> {
            if (b1.getTcode().equals(b2.getTcode())) {
                return b1.getCcode().compareTo(b2.getCcode());
            }
            return b1.getTcode().compareTo(b2.getTcode());
        });
    }

}
