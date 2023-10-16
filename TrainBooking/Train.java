package TrainBooking;

public class Train {

    private String tcode;
    private String trainName;
    private int seat;
    private int booked;
    private double departTime;
    private String departPlace;

    public Train() {
    }

    public Train(String tcode, String trainName, int seat, int booked, double departTime, String departPlace) {
        this.tcode = tcode;
        this.trainName = trainName;
        this.seat = seat;
        this.booked = booked;
        this.departTime = departTime;
        this.departPlace = departPlace;
    }

    public String getTcode() {
        return tcode;
    }

    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getBooked() {
        return booked;
    }

    public void setBooked(int booked) {
        this.booked = booked;
    }

    public double getDepartTime() {
        return departTime;
    }

    public void setDepartTime(double departTime) {
        this.departTime = departTime;
    }

    public String getDepartPlace() {
        return departPlace;
    }

    public void setDepartPlace(String departPlace) {
        this.departPlace = departPlace;
    }

    private Validation validation = new Validation();

    public void createTrain() {
        System.out.println("Input tcode: ");
        this.tcode = validation.inputString();
        System.out.println("Input train name: ");
        this.trainName = validation.inputString();
        System.out.println("Input seat: ");
        this.seat = validation.inputInt();
        System.out.println("Input booked seat: ");
        this.booked = validation.inputIntInRange(0, this.seat);
        System.out.println("Input depart time: ");
        this.departTime = validation.inputDouble();
        System.out.println("Input depart place: ");
        this.departPlace = validation.inputString();
    }

}
