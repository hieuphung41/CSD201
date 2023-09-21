package CSD201_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        boolean check = loadFromFile("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CSD201_4\\src\\csd201_4\\Data.txt", list);
        if (!check) {
            return;
        }
        for (Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println("");
        Collections.sort(list, (Integer o1, Integer o2) -> {
            if (o1 < o2) {
                return -1;
            } else if (o1 > o2) {
                return 1;
            }
            return 0;
        });
        System.out.println("Sorted: ");
        for (Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println("");
        System.out.print("Input number to find: ");
        int x = scanner.nextInt();
        scanner.nextLine();
        boolean result = findNum(x, list);
        if (!result) {
            System.out.println("Not found!");
        } else {
            System.out.println("Number exist!");
        }
    }

    public static boolean loadFromFile(String fileName, LinkedList<Integer> list) {
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
                    String[] parts = line.split("\\s+");
                    for (String part : parts) {
                        list.add(Integer.parseInt(part));
                    }
                    line = reader.readLine();
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean findNum(int x, LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return false;
        }
        int midIndex = (list.size() - 1) / 2;
        int midNum = list.get(midIndex);
        if (x == midNum) {
            return true;
        } else if (x < midNum) {
            LinkedList<Integer> newList = new LinkedList<>(list.subList(0, midIndex));
            return findNum(x, newList);
        } else {
            LinkedList<Integer> newList = new LinkedList<>(list.subList(midIndex + 1, list.size()));
            return findNum(x, newList);
        }
    }

}
