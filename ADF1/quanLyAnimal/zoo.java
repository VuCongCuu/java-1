package quanLyAnimal;
/*
 * 2.	Xây dựng chương trình quản lý Động vật
-	Xây dựng lớp Animal có các thông tin tên, tuổi, mô tả và có các hành động nhập và xem thông tin ( tên, tuổi, mô tả )
-	Xây dựng phương thức trừu tượng tiếng kêu
-	Xây dựng hàm tạo lớp Animal ( 0 tham số, 1 tham số ( tên ), 2 tham số ( tên, tuổi), 3 tham số ( tên, tuổi, mô tả )
-	Tạo lớp Tiger, Dog, Cat theo các yêu cầu:
+ Kế thừa lớp Animal
+ Ghi đè phương thức tiếng kêu để thể hiện đặc trưng của từng loài động vật
+ Thực thi các hàm tạo sử dụng từ khóa super
-	Tạo lớp Chuong gồm thông tin mã chuồng, danh sách động vật và có các hành động thêm con vật vào chuồng, xóa con vật khỏi chồng ( tương tự thêm, xóa khỏi list động vật )
-	Tạo lớp Zoo gồm thông tin danh sách chuồng, và có các hành động thêm 1 chuồng vào danh sách chuồng, xóa 1 chuồng khỏi danh sách.
-	Tạo lớp quản lý (ManageMain) sở thú theo dạng menu:
1: Thêm chuồng
2: Xóa chuồng
3: Thêm con vật
4: Xóa con vật
5: Xem tất cả các con vật
6: Thoát
-	Người dùng thêm các lại vật như Tiger, Dog, Cat vào chuồng
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class zoo {

    // --------- 1 them chuong --------------
    public void addChuong(List<chuong> zoo) {
        int lenght = zoo.size();
        zoo.add(new chuong());
        zoo.get(lenght).nhapTT();
    }

    // ----------- 2 xoa chuong ----------
    Scanner sc = new Scanner(System.in);

    public void delChuong(List<chuong> zoo) {

        int count = 0;
        for (chuong chuong : zoo) {
            System.out.print(++count + ". " + chuong.getMaChuong());
            if (count % 2 == 1) {
                System.out.print("\t\t");
            } else {
                System.out.println();
            }
        }
        System.out.print("Chon chuong can xoa: ");
        int choose = sc.nextInt();
        sc.nextLine();

        zoo.remove(choose - 1);
    }

    // ------------- 3 them vat -----------
    public void addAnimals(List<chuong> zoo) {

        int count = 0;
        for (chuong chuong : zoo) {
            System.out.print(++count + ". " + chuong.getMaChuong());
            if (count % 2 == 1) {
                System.out.print("\t\t");
            } else {
                System.out.println();
            }
        }
        System.out.print("Chon chuong can them: ");
        int choose = sc.nextInt();
        sc.nextLine();

        chuong chuong = zoo.get(choose - 1);
        chuong.chonAnimal(chuong.getDsAnimal());
    }

    // -------------- 4 xoas vat -----------------
    public void delAnimal(List<chuong> zoo) {

        int count = 0;
        for (chuong chuong : zoo) {
            System.out.print(++count + ". " + chuong.getMaChuong());
            if (count % 2 == 1) {
                System.out.print("\t\t");
            } else {
                System.out.println();
            }
        }
        System.out.print("Chon chuong: ");
        int choose = sc.nextInt();
        sc.nextLine();

        chuong chuong = zoo.get(choose - 1);
        List<animal> danhsach = chuong.getDsAnimal();

        while (true) {
            count = 0;
            for (animal animal : danhsach) {
                System.out.println("\n\t\tAnimal : " + ++count + animal.toString());
            }
            System.out.print("Chon animal can xoa: ");
            choose = sc.nextInt();
            sc.nextLine();
            if (choose > 0 && choose < danhsach.size()) {
                System.out.println("ban da xoa animal" + danhsach.get(choose - 1).toString());
                danhsach.remove(choose - 1);

            } else {
                System.out.println("Con vat khong ton tai");
            }
            System.out.print("\nBan co muon xoa con vat khong? (Y/N) (y) :");
            String check = sc.nextLine();
            if (check.equalsIgnoreCase("n"))
                break;
        }
    }

    // ----------- 5 xem vat ----------
    public void dsAnimal(List<chuong> zoo) {

        for (chuong chuong : zoo) {
            System.out.println("---------------------------------------------\n" + chuong.getMaChuong()
                    + "\n---------------------------------------------");
            chuong.dsAnimalString(chuong.getDsAnimal());
        }

    }

    public static void main(String[] args) {

        List<animal> chuong_1 = new ArrayList<>();
        chuong_1.add(new tiger("Ho van", 10, "hung du", "nhiet doi", "dai phong"));
        chuong_1.add(new tiger("Ho trang", 5, "hien lanh", "gio mua", "dai phong"));
        chuong_1.add(new dog("cho soi", 12, "hung du", "Son", "khong co"));
        chuong_1.add(new cat("meo den", 4, "hien lanh", "Vu", "tu tuc"));

        List<animal> chuong_2 = new ArrayList<>();
        chuong_2.add(new tiger("Ho den", 10, "hung du", "nhiet doi", "dai phong"));
        chuong_2.add(new tiger("Ho xam", 5, "hien lanh", "gio mua", "dai phong"));
        chuong_2.add(new dog("cho america", 12, "hien lanh", "Son", "khong co"));
        chuong_2.add(new cat("meo trang", 4, "hien lanh", "Vu", "tu tuc"));

        List<animal> chuong_3 = new ArrayList<>();
        chuong_3.add(new tiger("Ho do", 10, "hung du", "nhiet doi", "dai phong"));
        chuong_3.add(new dog("cho hubdi", 12, "hung du", "Son", "khong co"));
        chuong_3.add(new cat("meo alasca", 4, "hien lanh", "Vu", "tu tuc"));

        List<chuong> zoo = new ArrayList<>();
        zoo.add(new chuong("chuong_1", chuong_1));
        zoo.add(new chuong("chuong_2", chuong_2));
        zoo.add(new chuong("chuong_3", chuong_3));

        // /--------- main ----------------

        int choose;
        String check = "";
        Scanner sc = new Scanner(System.in);
        zoo zooMain = new zoo();

        while (true) {
            System.out.print("1. Them chuong");
            System.out.println("\t\t2. Xoa chuong");
            System.out.print("3. Them animal");
            System.out.println("\t\t4. Xoa vat");
            System.out.print("5. Danh sach animal");
            System.out.println("\t6. Thoat...");

            System.out.print("\n\nNhap lua chon: ");
            choose = sc.nextInt();
            sc.nextLine();

            switch (choose) {
            case 1:
                zooMain.addChuong(zoo);
                break;
            case 2:
                zooMain.delChuong(zoo);

                break;
            case 3:
                zooMain.addAnimals(zoo);

                break;
            case 4:
                zooMain.delAnimal(zoo);

                break;
            case 5:
                zooMain.dsAnimal(zoo);

                break;
            case 6:
                break;

            default:
                System.out.println("Lua chon khong phu hop");

            }
            if (choose == 6)
                break;
            System.out.print("\n\nban co muon tiep tuc khong? (Y/N) (Y) : ");
            check = sc.nextLine();
            if (check.equalsIgnoreCase("n"))
                break;
        }
        sc.close();
        System.out.println("Thank you used us service!");
    }
}
