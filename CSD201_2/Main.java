package CSD201_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        MyStack myStack = new MyStack();
        String num;
        do {
            System.out.print("Input positive integer: ");
            num = scanner.nextLine();
            if (!isPositiveInteger(num)) System.out.println("Invalid! Input again!");
        } while (!isPositiveInteger(num));
        int n = Integer.parseInt(num);
        while (n>0) {
            int tmp = n%2;
            myStack.list.push(tmp);
            n/=2;
        }
        String output = "";
        System.out.print("Binary: ");
        while (!(myStack.list.isEmpty())) {
            output+=myStack.list.pop();
        }
        System.out.println(output);
    }

    //    validation
    public static boolean isPositiveInteger(String input) {
        return input.matches("[0-9]+") && Integer.parseInt(input) > 0;
    }

}
