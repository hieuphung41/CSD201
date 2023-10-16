package TrainBooking;

public class Booking {

    private String ccode;
    private String tcode;
    private int seat;

    public Booking() {
    }

    public Booking(String ccode, String tcode, int seat) {
        this.ccode = ccode;
        this.tcode = tcode;
        this.seat = seat;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

//    public int compareTo(Booking other) {
//        if (this.tcode.equals(other.tcode)) {
//            return this.ccode.compareTo(other.ccode);
//        }
//        return this.tcode.compareTo(other.ccode);
//    }

    private Validation validation = new Validation();

    public void createBooking() {
        System.out.println("Input ccode: ");
        this.ccode = validation.inputString();
        System.out.println("Input tcode: ");
        this.tcode = validation.inputString();
        System.out.println("Input seat: ");
        this.seat = validation.inputInt();
    }

}
