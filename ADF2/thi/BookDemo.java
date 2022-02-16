//package thi;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import ass2.Main;
//
//public class BookDemo {
//    private File root = new File(System.getProperty("user.dir"));
//    private final File file = new File(root, "JavaT2104");
//    
//    public static boolean addBook(List<Book> listbooks, Scanner sc) {
//        boolean check = false;
//        Book sach = new Book();
//        sach.addbook();
//        check = listbooks.add(sach);
//        return check;
//    }
//    public static boolean saveBook(List<Book> lbooks) {
//        FileOutputStream writeFile = null;
//        ObjectOutputStream objectWrite = null;
//        try {
//            writeFile = new FileOutputStream(file);
//            objectWrite = new ObjectOutputStream(writeFile);
//            objectWrite.writeObject(lbooks);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        } finally {
//            try {
//                objectWrite.close();
//                writeFile.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return true;
//    }
//
//    public static void displayBook() {
//        FileInputStream readFile = null;
//        ObjectInputStream objectRead = null;
//        try {
//            readFile = new FileInputStream(file);
//            objectRead = new ObjectInputStream(readFile);
//            Object listBook = objectRead.readObject();
//
//            if (listBook instanceof List) {
//                List<Book> lBooks = (List<Book>) listBook;
//                for (Book book : lBooks) {
//                    System.out.println(book.toString());
//                }
//            } else if (listBook instanceof Book) {
//                System.out.println(listBook.toString());
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                readFile.close();
//                objectRead.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Main MainBook = new Main();
//        List<Book> lBooks = new ArrayList<>();
//
//        int choose;
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("======== MAIN ==========");
//            System.out.println("1. Thêm book");
//            System.out.println("2. Lưu book");
//            System.out.println("3. Hiển thị book");
//            System.out.println("4. Thêm book");
//            System.out.println("Nhap lua chon: ");
//
//            try {
//                choose = sc.nextInt();
//                sc.nextLine();
//            } catch (Exception e) {
//                sc.nextLine();
//                choose = 5;
//            }
//
//            switch (choose) {
//                case 1:
//                    if (BookDemo.addBook(lBooks, sc)) {
//                        System.out.println("Thêm thành công");
//                    } else {
//                        System.out.println("Thêm thất bại");
//
//                    }
//                    break;
//
//                case 2:
//                	BookDemo.saveBook(lBooks);
//                    break;
//
//                case 3:
//                	BookDemo.displayBook();
//                    break;
//
//                case 4:
//                    break;
//
//                default:
//                    System.out.println("Lua chon khong đúng!");
//            }
//            if (choose == 4)
//                break;
//        }
//        sc.close();
//        System.out.println("Cảm ơn");
//
//    }
//}
