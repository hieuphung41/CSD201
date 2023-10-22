package TrainBooking;

import java.util.Scanner;

public class Validation {

    private Scanner scanner = new Scanner(System.in);

    public String inputString() {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                if (!str.isEmpty()) {
                    return str;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid string!");
                System.out.println("Input again: ");
            }
        }
    }

    public int inputInt() {
        while (true) {
            try {
                int x = Integer.parseInt(scanner.nextLine().trim());
                if (x > 0) {
                    return x;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer!");
                System.out.println("Input again: ");
            }
        }
    }

    public int inputIntInRange(int min, int max) {
        while (true) {
            try {
                int x = Integer.parseInt(scanner.nextLine().trim());
                if (x >= min && x <= max) {
                    return x;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer!");
                System.out.println("Input again: ");
            }
        }
    }

    public double inputDouble() {
        while (true) {
            try {
                double x = Double.parseDouble(scanner.nextLine().trim());
                if (x >= 0) {
                    return x;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer!");
                System.out.println("Input again: ");
            }
        }
    }

    public String inputValidPhone() {
        while (true) {
            try {
                String str = scanner.nextLine().trim();
                if (str.matches("^[0-9]+$")) {
                    return str;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Invalid phone!");
                System.out.println("Input again: ");
            }
        }
    }

}
