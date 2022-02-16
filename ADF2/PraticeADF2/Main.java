package PraticeADF2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private File root = new File(System.getProperty("user.dir"));
    private final File file = new File(root, "D:\\T2104E\\Java2");
    
    public boolean addBook(List<Book> listbooks, Scanner sc) {
        boolean check = false;
        Book sach = new Book();
        sach.nhapTT(sc);
        check = listbooks.add(sach);
        return check;
    }
    public boolean saveBook(List<Book> lbooks) {
        FileOutputStream writeFile = null;
        ObjectOutputStream objectWrite = null;
        try {
            writeFile = new FileOutputStream(file);
            objectWrite = new ObjectOutputStream(writeFile);
            objectWrite.writeObject(lbooks);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                objectWrite.close();
                writeFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public void displayBook() {
        FileInputStream readFile = null;
        ObjectInputStream objectRead = null;
        try {
            readFile = new FileInputStream(file);
            objectRead = new ObjectInputStream(readFile);
            Object listBook = objectRead.readObject();

            if (listBook instanceof List) {
                List<Book> lBooks = (List<Book>) listBook;
                for (Book book : lBooks) {
                    System.out.println(book.toString());
                }
            } else if (listBook instanceof Book) {
                System.out.println(listBook.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                readFile.close();
                objectRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Main MainBook = new Main();
        List<Book> lBooks = new ArrayList<>();

        int choose;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======== MAIN ==========");
            System.out.println("1. Them book");
            System.out.println("2. Luu book");
            System.out.println("3. Hien thi book");
            System.out.println("4. them book");
            System.out.println("Nhap lua chon: ");

            try {
                choose = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                sc.nextLine();
                choose = 5;
            }

            switch (choose) {
                case 1:
                    if (MainBook.addBook(lBooks, sc)) {
                        System.out.println("Them thanh cong");
                    } else {
                        System.out.println("Them that bai");

                    }
                    break;

                case 2:
                    MainBook.saveBook(lBooks);
                    break;

                case 3:
                    MainBook.displayBook();
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Lua chon khong dung!");
            }
            if (choose == 4)
                break;
        }
        sc.close();
        System.out.println("Cảm ơn");

    }
}
