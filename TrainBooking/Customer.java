package TrainBooking;

public class Customer {

    private String ccode;
    private String cusName;
    private String phone;

    public Customer() {
    }

    public Customer(String ccode, String cusName, String phone) {
        this.ccode = ccode;
        this.cusName = cusName;
        this.phone = phone;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private Validation validation = new Validation();

    public void createCustomer() {
        System.out.println("Input ccode: ");
        this.ccode = validation.inputString();
        System.out.println("Input customer name: ");
        this.cusName = validation.inputString();
        System.out.println("Input phone: ");
        this.phone = validation.inputValidPhone();
    }

}
