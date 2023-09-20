package CSD201_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        LinkedList<Student> list = new LinkedList();
        loadFromFile("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CSD201_1\\sinhvien.txt", list);
        run(scanner, list);
    }

    //    ----------------------------running
    public static void run(Scanner scanner, LinkedList<Student> list) {
        boolean check = true;
        do {
            menu();
            String choice;
            System.out.println("Nhap lua chon cua ban: ");
            do {
                choice = scanner.nextLine();
                if (!isValidChoice(choice)) {
                    System.out.println("Chi duoc lua chon 3 option tren! Nhap lai: ");
                }
            } while (!isValidChoice(choice));
            int input = Integer.parseInt(choice);
            switch (input) {
                case 1:
                    boolean repeat = false;
                    String todo;
                    do {
                        addData(scanner, list);
                        System.out.println("Ban muon nhap tiep khong? (Y is yes, N is no): ");
                        todo = scanner.nextLine();
                        if (todo.equalsIgnoreCase("y")) {
                            repeat = true;
                        } else {
                            repeat = false;
                        }
                    } while (repeat);
                    break;
                case 2:
                    find(scanner, list);
                    break;
                case 3:
                    check = false;
                    System.out.println("Bye");
                    break;
                default:
                    System.out.println("Invalid!");
                    break;
            }
        } while (check);
    }

    //    ------------------------------menu
    public static void menu() {
        System.out.println("---------- Menu ----------");
        System.out.println("1. Nhap du lieu");
        System.out.println("2. Khai thac thong tin");
        System.out.println("3. Thoat khoi chuong trinh");
    }

    //    ----------------------------------file
    public static boolean loadFromFile(String fileName, LinkedList<Student> list) {
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
                    String[] parts = line.split(", ");
                    String maSinhVien = parts[0].trim();
                    String tenSinhVien = parts[1].trim();
                    String ngaySinh = parts[2].trim();
                    String diaChi = parts[3].trim();
                    list.add(new Student(maSinhVien, tenSinhVien, ngaySinh, diaChi));
                    line = reader.readLine();
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static boolean saveToFile(String fileName, LinkedList<Student> list) {
        try {
            try (FileWriter writer = new FileWriter(fileName)) {
                for (Student x : list) {
                    String line = x.getMaSinhVien() + ", " + x.getTenSinhVien() + ", " + x.getNgaySinh() + ", " + x.getDiaChi() + "\n";
                    writer.write(line);
                }
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    //    ----------------------application
    public static void addData(Scanner scanner, LinkedList<Student> list) {
        String maSinhVien, tenSinhVien, diaChi, ngaySinh;
        System.out.println("Nhap ma sinh vien: ");
        do {
            maSinhVien = scanner.nextLine();
            if (!isValidID(maSinhVien)) {
                System.out.println("ID phai co dang XX000000. Nhap lai ID: ");
            }
        } while (!isValidID(maSinhVien));
        System.out.println("Nhap ten sinh vien: ");
        do {
            tenSinhVien = scanner.nextLine();
            if (!isValidName(tenSinhVien)) {
                System.out.println("Ten chi bao gom chu cai. Nhap lai ten: ");
            }
        } while (!isValidName(tenSinhVien));
        System.out.println("Nhap ngay sinh cua sinh vien: ");
        do {
            ngaySinh = scanner.nextLine();
            if (!isValidDate(ngaySinh)) {
                System.out.println("Ngay sinh phai co dang dd/MM/yyyy. Nhap lai ngay sinh: ");
            }
        } while (!isValidDate(ngaySinh));
        System.out.println("Nhap dia chi cua sinh vien: ");
        do {
            diaChi = scanner.nextLine();
            if (!isValidAddress(diaChi)) {
                System.out.println("Dia chi khong bao gom cac ki tu da biet. Nhap lai dia chi: ");
            }
        } while (!isValidAddress(diaChi));
        list.add(new Student(maSinhVien, tenSinhVien, ngaySinh, diaChi));
        saveToFile("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CSD201_1\\sinhvien.txt", list);
        System.out.println("Da them thanh cong!");
    }

    public static void find(Scanner scanner, LinkedList<Student> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty!");
            return;
        }
        String maSinhVien;
        System.out.println("Nhap ma sinh vien: ");
        do {
            maSinhVien = scanner.nextLine();
            if (!isValidID(maSinhVien)) {
                System.out.println("ID phai co dang XX000000. Nhap lai ID: ");
            }
        } while (!isValidID(maSinhVien));
        int count = 0;
        for (Student x : list) {
            if (x.getMaSinhVien().equalsIgnoreCase(maSinhVien)) {
                count++;
                System.out.println(x.getMaSinhVien() + ", " + x.getTenSinhVien() + ", " + x.getNgaySinh() + ", " + x.getDiaChi());
            }
        }
        if (count == 0) {
            System.out.println("Khong tim thay sinh vien!");
        }

    }

    //    check valid
    public static boolean isValidChoice(String input) {
        return input.matches("^[1-3]$");
    }

    public static boolean isValidID(String input) {
        return input.matches("^[A-Z]{2}[0-9]{6}$");
    }

    public static boolean isValidName(String input) {
        return input.matches("^[A-Za-z]+( [A-Za-z]+)*$");
    }

    public static boolean isValidAddress(String input) {
        return input.matches("^[0-9A-Za-z,. ]+$");
    }

    public static boolean isValidDate(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}
