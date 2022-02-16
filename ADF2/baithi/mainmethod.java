package baithi;

import java.util.Scanner;

public class mainmethod {
	public static class Main {
	

        public static void main(String[] args) {
            Book book = new Book();
            option option= new option();
            Scanner sc = new Scanner(System.in);
            int n;
            int choose;
            String confirm = "";
            do {
                System.out.println("1:them 1 cuon sach");
                System.out.println("2:ghi file");
                System.out.println("3:hien thi thu vien");
                System.out.println("4:thoat");

                while (true) {
                    System.out.println("nhap lua con cua ban : ");
                    choose = sc.nextInt();
                    if (choose >= 1 && choose <= 4) {
                        break;
                    }
                }

                switch (choose) {
                    case 1:
                    	System.out.println("them 1 cuon sach");
                    	book.NhapTT();
                        if(option.addBook(book)==true) {
                        	System.out.println("Them thanh cong");
                        } else {
                        	System.out.println("them that bai");
                        }
                        
                        break;
                    case 2:
                    	 System.out.println("2:ghi file");
                    	 option.saveFile(option.booklist);
                        break;
                    case 3:
                    	 System.out.println("3:hien thi thu vien");
                    	 option.readFile();
              
                        break;

                    case 4:
                        System.out.println("Thoat chuong trinh");
                        System.exit(choose);

                }
                sc.nextLine();
                System.out.println("ban co muon tiep tuc khong (y = ok).");
                confirm = sc.nextLine();

            } while (confirm.equalsIgnoreCase("y"));


        }


    }

}
