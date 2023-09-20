package CSD201_3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        MyQueue qList = new MyQueue();
        LinkedList<Person> beingList = new LinkedList<>();
        LinkedList<Person> doneList = new LinkedList<>();
        int id = 1;
        while (true) {
            menu();
            int choice = getUserChoice(scanner);
            switch (choice) {
                case 1:
                    function1(scanner, qList, id);
                    id++;
                    break;
                case 2:
                    function2(qList, beingList);
                    break;
                case 3:
                    function3(scanner, beingList, doneList);
                    break;
                case 4:
                    function4(qList, beingList, doneList);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid!");
            }
        }
    }

    //    view
    public static void menu() {
        System.out.println("========== Menu ==========");
        System.out.println("1. Tiep nhan khach hang");
        System.out.println("2. Dua vao phuc vu");
        System.out.println("3. Hoan tat phuc vu");
        System.out.println("4. Bao cao");
        System.out.println("5. Exit");
    }

    //    function
    public static int getUserChoice(Scanner scanner) {
        String input;
        do {
            System.out.print("> Your choice: ");
            input = scanner.nextLine();
            if (!isValidChoice(input)) {
                System.out.println("Input again!");
            }
        } while (!isValidChoice(input));
        return Integer.parseInt(input);
    }

    public static void function1(Scanner scanner, MyQueue qList, int id) {
        String name, job;
        System.out.print("Input your name: ");
        name = scanner.nextLine();
        System.out.print("Input your job: ");
        job = scanner.nextLine();
        qList.enqueue(new Person(id, name, job));
        System.out.println("Danh sach tiep nhan hien tai: ");
        qList.display();
    }

    public static void function2(MyQueue qList, LinkedList<Person> beingList) {
        if (qList.isEmpty()) {
            System.out.println("Khong co khach hang duoc tiep nhan!");
            return;
        }
        beingList.add(qList.dequeue());
        qList.display();
        System.out.println("Danh sach phuc vu hien tai: ");
        for (Person x : beingList) {
            System.out.println(x.getSTT() + ", " + x.getName() + ", " + x.getJob());
        }
    }

    public static void function3(Scanner scanner, LinkedList<Person> beingList, LinkedList<Person> doneList) {
        if (beingList.isEmpty()) {
            System.out.println("Khong co khach hang trong danh sach dang phuc vu!");
            return;
        }
        String id;
        int count = 0;
        LinkedList<Person> tmp = new LinkedList<>();
        do {
            System.out.print("Input id: ");
            id = scanner.nextLine();
            if (!isPositiveInteger(id)) {
                System.out.println("Input again!");
            }
        } while (!isPositiveInteger(id));
        int validID = Integer.parseInt(id);
        for (Person x : beingList) {
            if (x.getSTT() == validID) {
                doneList.add(x);
                tmp.add(x);
                count++;
            }
        }
        beingList.removeAll(tmp); // sau khi them khach hang vao nhom da hoan tat phuc vu, xoa bo khach hang trong nhom dang phuc vu
        if (count == 0) {
            System.out.println("Khong tim thay khach hang!");
        } else {
            System.out.println("Danh sach da hoan thanh hien tai: ");
            for (Person x : doneList) {
                System.out.println(x.getSTT() + ", " + x.getName() + ", " + x.getJob());
            }
        }
    }

    public static void function4(MyQueue qList, LinkedList<Person> beingList, LinkedList<Person> doneList) {
        System.out.println("Danh sach tiep nhan: ");
        qList.display();
        System.out.println("Danh sach phuc vu: ");
        for (Person x : beingList) {
            System.out.println(x.getSTT() + ", " + x.getName() + ", " + x.getJob());
        }
        System.out.println("Danh sach da hoan thanh: ");
        for (Person x : doneList) {
            System.out.println(x.getSTT() + ", " + x.getName() + ", " + x.getJob());
        }
    }

    //    validation
    public static boolean isValidChoice(String input) {
        return input.matches("^[1-5]$");
    }

    public static boolean isPositiveInteger(String input) {
        return input.matches("^[1-9]\\d*$");
    }

}
