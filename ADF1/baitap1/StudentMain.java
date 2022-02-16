package baitap1;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args){
        String confirm = "";
        PerSonal per1 = new PerSonal();
        Student std1 = new Student();
        PerSonal per2 = new Student();
        System.out.println("Nhap thong tin sinh vien 1: ");
        per2.ThongTin();
        System.out.println(per2.toString());
        per2 = per1;
        per2 = std1;
        System.out.println("Nhap thong tin sinh vien 2: ");
        Student std2 = (Student) per2;
        std2.ThongTin();
        System.out.println(std2.toString());
        PerSonal per3 = new PerSonal();
        Teacher teacher1 = new Teacher();
        PerSonal per4 = new Teacher();
        System.out.println("Nhap thong tin giang vien 1: ");
        per4.ThongTin();
        System.out.println(per4);
        per4 = per3;
        per4 = teacher1;
        System.out.println("Nhap thong tin giang vien 2: ");
        Teacher teacher2 = (Teacher) per4;
        teacher2.ThongTin();
        System.out.println(teacher2.toString());
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1: Nhập giảng viên và thêm giảng viên : ");
            System.out.println("2: Nhập học sinh và thêm học sinh  ");
            System.out.println("3: Nhập người và thêm người  ");
            System.out.println("4: Hiển thị thông tin danh sách quản lý  ");
            System.out.println("5: Hiển thị danh sách sinh viên và xếp loại của sinh viên  ");
            System.out.println("6: Hiển thị danh sách giáo viên và lương của giáo viên ");
            System.out.println("7: thoat ");
            System.out.println("Chá»n tá»« 1 Ä‘áº¿n 7 : ");
            int choose = sc.nextInt();
            switch (choose){
                case 1:
                    System.out.println("11: Nhập giảng viên và thêm giảng viên :");
                    per2.ThongTin();
                    per4.ThongTin();
                    break;
                case 2:
                    System.out.println("2: Nhập học sinh và thêm học sinh ");
                    per2.ThongTin();

                    break;
                case 3:
                    System.out.println("3: Nhập người và thêm người  ");
                    break;
                case 4:
                    System.out.println("4: Hiển thị thông tin danh sách quản lý ");
                    break;
                case 5:
                    System.out.println("5: Hiển thị danh sách sinh viên và xếp loại của sinh viên ");
                    break;
                case 6:
                    System.out.println("6: Hiển thị danh sách giáo viên và lương của giáo viên ");
                    break;
                case 7:
                    System.out.println("7: thoat ");
                    break;
                default:
                    System.out.println("Case khong hop le!");
                    break;
            }
            if(choose == 6){
                break;
            }
            sc.nextLine();
            System.out.println("Báº¡n cÃ³ muá»‘n tiáº¿p tá»¥c?(n = stop)");
        } while (!"n".equalsIgnoreCase(confirm));
    }

    public static void ThemHocSinh(Student learn){
                Scanner sc = new Scanner(System.in);
                int LuongHS = 0;
                do{
                    System.out.println("Ban muon them bao nhieu quyen sach");
                    LuongHS = sc.nextInt();
                }while (LuongHS <=0);
                Student[] Them = new Student[LuongHS];
                for (int i = 0; i < LuongHS ; i++){
                    Student hocSinh = new Student();
                    hocSinh.ThongTin();
                    Them[i] = hocSinh;
                }
                int SoluongSVduocThem = learn.ThongTin();
                System.out.println("Co so luong : " +SoluongSVduocThem+"Ä‘Æ°á»£c thÃªm!" );
    }
}

