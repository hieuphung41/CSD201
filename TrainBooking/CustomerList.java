package TrainBooking;

import java.io.*;
import java.util.LinkedList;

public class CustomerList {

    LinkedList<Customer> list = new LinkedList<>();

    //    2.1.      Load data from file
    public boolean loadDataFromFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println(file + " does not exist. Creating a new file.");
                if (file.createNewFile()) {
                    System.out.println("File created successfully.");
                } else {
                    System.out.println("Failed to create file.");
                    return false;
                }
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line = reader.readLine();
                while (line != null) {
                    String[] parts = line.split(",");
                    String ccode = parts[0].trim();
                    String cusName = parts[1].trim();
                    String phone = parts[2].trim();
                    list.add(new Customer(ccode, cusName, phone));
                    line = reader.readLine();
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    //    2.2.      Input & add to the end
    public Customer input() {
        Customer customer = new Customer();
        customer.createCustomer();
        return customer;
    }

    public void insertData(Customer customer) {
        list.addLast(customer);
    }

    //    2.3.      Display data
    public void displayData() {
        for (Customer x : list) {
            System.out.println(x.getCcode() + ", " + x.getCusName() + ", " + x.getPhone());
        }
    }

    //    2.4.      Save customer list to file
    public boolean saveToFile(String fileName) {
        try {
            try (FileWriter writer = new FileWriter(fileName)) {
                for (Customer x : list) {
                    String line = x.getCcode() + ", " + x.getCusName() + ", " + x.getPhone() + "\n";
                    writer.write(line);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    //    2.5.      Search by ccode
    public Customer searchCustomer(String ccode) {
        for (Customer x : list) {
            if (x.getCcode().equals(ccode)) {
                return x;
            }
        }
        return null;
    }

    //    2.6.      Delete by ccode
    public void deleteByCcode(String ccode) {
        LinkedList<Customer> lst = new LinkedList<>();
        for (Customer x : list) {
            if (x.getCcode().equals(ccode)) {
                lst.addLast(x);
            }
        }
        list.removeAll(lst);
    }

}
