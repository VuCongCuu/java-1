package thu_vien_2;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;
import java.util.Scanner;

public class library {
    public static List<documents> taiLieu = new ArrayList<>();
    public static int lengthTaiLieu;

    // ---------- 1.them tai lieu ------------------
    Scanner sc = new Scanner(System.in);

    public void addDocuments() {
        int choose;
        while (true) {
            System.out.print("1. Book");
            System.out.println("\t\t2. Journal");
            System.out.print("3. Newspaper");
            System.out.println("\t\t4. Thoat");
            System.out.print("\nchon kieu tai lieu: ");
            choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
            case 1:
                taiLieu.add(new book());
                break;
            case 2:
                taiLieu.add(new tapChi());

                break;
            case 3:
                taiLieu.add(new bao());
                break;
            case 4:
                break;

            default:
                System.out.println("tai lieu khong ton tai");
            }
            if (choose == 4)
                break;
            taiLieu.get(lengthTaiLieu++).NhapTT();
        }

    }

    // -------- 2. xoa tai lieu ------------
    public void moveDocuments() {
        int count = 0;
        while (true) {
            count = 0;
            for (documents document : taiLieu)
                System.out.println("\t\tTai Lieu ----> " + ++count + document.toString());

            System.out.print("\nChon tai lieu ban muon xoa " + "or Press: " + ++count + " de thoat ");
            int choose = sc.nextInt();
            sc.nextLine();
            if (choose == count)
                break;
            taiLieu.remove(choose - 1);
            lengthTaiLieu--;
        }

    }

    // ----------- 3. xem danh sach ----------
    public void listThuVien() {
        int countBook = 0, countTapChi = 0, countBao = 0;
        System.out.println("---------------------------------------------------\n" + "thu vien Sach\n"
                + "--------------------------------------------------\n");
        for (documents document : taiLieu) {
            if (document instanceof book) {
                countBook++;
                System.out.println("\t\t Book ---->  " + countBook + document.toString());
            }
        }

        System.out.println("---------------------------------------------------\n" + "thu vien tap chi\n"
                + "--------------------------------------------------\n");
        for (documents document : taiLieu) {
            if (document instanceof tapChi) {
                countTapChi++;
                System.out.println("\t\t Tap chi ---->  " + countTapChi + document.toString());
            }
        }

        System.out.println("---------------------------------------------------\n" + "thu vien bao\n"
                + "--------------------------------------------------\n");
        for (documents document : taiLieu) {
            if (document instanceof bao) {
                countBao++;
                System.out.println("\t\t bao ---->  " + countBao + document.toString());
            }
        }
    }

    // -------------- 4. tim sach --------------
    public void timSach() {
        String nameTaiLieu = "";
        boolean check = false;
        String out = "";
        while (true) {
            System.out.print("Nhap ten taiLieu can tim: ");
            nameTaiLieu = sc.nextLine();
            System.out.print("Tai lieu ban can tim la: \n");
            for (documents document : taiLieu) {
                if (document.getNameTaiLieu().contains(nameTaiLieu)) {
                    System.out.println(document.toString());
                    check = true;
                }

            }
            if (!check)
                System.out.println("Khong tim thay");

            System.out.print("Ban co muon tiep tuc khong (Y/N) (y) : ");
            out = sc.nextLine();
            if (out.equalsIgnoreCase("n"))
                break;
        }

    }

    // ------------ 5. sap xep theo ten -------------------
    public void sapXep() {
        Collections.sort(taiLieu);
        for (documents documents : taiLieu) {
            System.out.println(documents.toString());
        }
    }

    // ------------ 6. sap xep theo gai -------------------
    public void sapXepTheoGia() {
        Collections.sort(taiLieu, new sapXepTheoGia());
        for (documents documents : taiLieu) {
            System.out.println(documents.toString());
        }
    }

    // ------------- main ------------------

    public static void main(String[] args) {

        library thuVien = new library();

        // ----------- sachs ------------------
        taiLieu.add(new thu_vien_2.book("book2005", "sach trinh tham", "kim Dong", 3000, "Truong Son", 500));
        taiLieu.add(new thu_vien_2.book("book2006", "hao khi Viet Nam", "kim Dong", 3000, "Truong Son", 300));
        taiLieu.add(new thu_vien_2.book("book1203", "ta chi song 1 lan", "kim Dong", 4000, "Truong Son", 400));
        taiLieu.add(new tapChi("journal1109", "Tap chi kinh te", "Tap chi VN", 1000, 11, 9));
        taiLieu.add(new tapChi("journal1108", "Tap chi kinh doanh", "Tap chi VN", 1000, 12, 8));
        taiLieu.add(new tapChi("journal1112", "Tap chi gia dinh", "Tap chi VN", 100000, 13, 12));
        taiLieu.add(new bao("bao1000", "bao la cai", "bao Nhan dan", 10000, "13/10/2020"));
        taiLieu.add(new bao("bao1001", "bao gia dinh", "bao Nhan dan", 8000000, "13/10/2021"));
        taiLieu.add(new bao("bao1000", "bao hoc tro", "bao Nhan dan", 10000, "13/03/2021"));

        taiLieu.set(1, new book("book", "hao khi Viet Nam", "kim Dong", 3000, "Truong Son", 300));
        // --------- main ---------------
        lengthTaiLieu = taiLieu.size();
        int choose;
        String check = "";
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("1. Add documents");
            System.out.println("\t\t  2. Delete documents");
            System.out.print("3. View list documents");
            System.out.println("\t\t  4. Search documents by name");
            System.out.print("5. Sap xep theo ten");
            System.out.println("\t\t  6. Sap xep theo gia");

            System.out.print("7. Thoat ...");

            System.out.print("\nNhap lua chon cua ban: ");
            choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
            case 1:
                thuVien.addDocuments();
                continue;
            case 2:
                thuVien.moveDocuments();

                continue;

            case 3:
                thuVien.listThuVien();
                break;
            case 4:
                thuVien.timSach();
                continue;
            case 5:
                thuVien.sapXep();

                break;
            case 6:
                thuVien.sapXepTheoGia();

                break;
            case 7:

                break;

            default:
                System.out.println("Lua chon khong hop ly");
                continue;
            }

            if (choose == 7)
                break;

            System.out.print("\nBan co muon tiep tuc khong (Y/N) (y) : ");
            check = sc.nextLine();
            if ("n".equalsIgnoreCase(check))
                break;
        }
        sc.close();
        System.out.println("\n\t\tthanks you!");
    }
}
