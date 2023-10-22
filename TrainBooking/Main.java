package TrainBooking;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Validation validation = new Validation();
        BinaryTree bst = new BinaryTree();
        CustomerList cusList = new CustomerList();
        BookingList bookList = new BookingList();
        while (true) {
            menu();
            System.out.println("> Your choice: ");
            int choice = validation.inputIntInRange(0, 3);
            switch (choice) {
                case 1:
                    trainFunction(validation, bst);
                    break;
                case 2:
                    customerFunction(validation, cusList);
                    break;
                case 3:
                    bookingFunction(validation, bookList);
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Invalid choice!");
            }
        }
    }

    public static void trainFunction(Validation validation, BinaryTree bst) {
        while (true) {
            TrainMenu();
            System.out.println("> Your choice: ");
            int choice = validation.inputIntInRange(0, 9);
            switch (choice) {
                case 1:
                    bst.loadDataFromFile("C:\\Users\\Admin\\Documents\\NetBeansProjects\\TrainBooking\\src\\trainbooking\\trains.txt");
                    break;
                case 2:
                    bst.insertData(bst.input());
                    break;
                case 3:
                    bst.inOrderTraverse(bst.root);
                    break;
                case 4:
                    bst.breadthFirstTraverse(bst.root);
                    break;
                case 5:
                    bst.inOrderTraverseToFile("C:\\Users\\Admin\\Documents\\NetBeansProjects\\TrainBooking\\src\\trainbooking\\trains_output.txt");
                    break;
                case 6:
                    String tcode = validation.inputString();
                    bst.visit(bst.searchByTcode(bst.root, tcode));
                    break;
                case 7:
                    String tcode1 = validation.inputString();
                    bst.deleteTcodeByCopy(tcode1);
                    break;
                case 8:
                    bst.bal();
                    break;
                case 9:
                    System.out.println("Number of trains: " + bst.countTrains(bst.root));
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Invalid choice!");
            }
        }
    }

    public static void customerFunction(Validation validation, CustomerList cusList) {
        while (true) {
            CustomerMenu();
            System.out.println("> Your choice: ");
            int choice = validation.inputIntInRange(0, 6);
            switch (choice) {
                case 1:
                    cusList.loadDataFromFile("C:\\Users\\Admin\\Documents\\NetBeansProjects\\TrainBooking\\src\\trainbooking\\customers.txt");
                    break;
                case 2:
                    cusList.insertData(cusList.input());
                    break;
                case 3:
                    cusList.displayData();
                    break;
                case 4:
                    cusList.saveToFile("C:\\Users\\Admin\\Documents\\NetBeansProjects\\TrainBooking\\src\\trainbooking\\customers_output.txt");
                    break;
                case 5:
                    System.out.println(cusList.searchCustomer(validation.inputString()).toString());
                    break;
                case 6:
                    cusList.deleteByCcode(validation.inputString());
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Invalid choice!");
            }
        }
    }

    public static void bookingFunction(Validation validation, BookingList bookList) {
        while (true) {
            BookingMenu();
            System.out.println("> Your choice: ");
            int choice = validation.inputIntInRange(0, 3);
            switch (choice) {
                case 1:
                    bookList.inputData();
                    break;
                case 2:
                    bookList.displayBookingData();
                    break;
                case 3:
                    bookList.sort();
                    break;
                case 0:
                    return;
                default:
                    System.err.println("Invalid choice!");
            }
        }
    }

    public static void TrainMenu() {
        System.out.println("========== Train menu ==========");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & insert data");
        System.out.println("3. In-order traverse");
        System.out.println("4. Breadth-first traverse");
        System.out.println("5. In-order traverse to file");
        System.out.println("6. Search by tcode");
        System.out.println("7. Delete by tcode by copying");
        System.out.println("8. Simply balancing");
        System.out.println("9. Count number of trains");
        System.out.println("0. Return");
    }

    public static void CustomerMenu() {
        System.out.println("========== Customer menu ==========");
        System.out.println("1. Load data from file");
        System.out.println("2. Input & add to the end");
        System.out.println("3. Display data");
        System.out.println("4. Save customer list to file");
        System.out.println("5. Search by ccode");
        System.out.println("6. Delete by ccode");
        System.out.println("0. Return");
    }

    public static void BookingMenu() {
        System.out.println("========== Booking menu ==========");
        System.out.println("1. Input data");
        System.out.println("2. Display booking data");
        System.out.println("3. Sort by tcode + ccode");
        System.out.println("0. Return");
    }

    public static void menu() {
        System.out.println("========== Menu ==========");
        System.out.println("1. Train");
        System.out.println("2. Customer");
        System.out.println("3. Booking");
        System.out.println("0. Exit");
    }

}
