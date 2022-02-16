package quanLyAnimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class chuong {
    private String maChuong;
    private List<animal> dsAnimal = new ArrayList<>();

    // --------- constructor -------------------

    public chuong(String maChuong, List<animal> dsAnimal) {
        this.maChuong = maChuong;
        this.dsAnimal = dsAnimal;
    }

    public chuong() {
    }

    // --------------- set, get ---------------

    public String getMaChuong() {
        return maChuong;
    }

    public void setMaChuong(String maChuong) {
        this.maChuong = maChuong;
    }

    public List<animal> getDsAnimal() {
        return dsAnimal;
    }

    public void setDsAnimal(List<animal> dsAnimal) {
        this.dsAnimal = dsAnimal;
    }

    // -------------- mo rong ------------------

    public String dsAnimalString(List<animal> dsAnimal) {
        String ds = "";
        int countTiger = 0;
        int countDog = 0;
        int countCat = 0;
        int countAnimal = 0;
        for (animal animal : dsAnimal) {
            if (animal instanceof tiger) {
                ++countTiger;
                System.out.println("\n\t\tTiger : " + countTiger + animal.toString());
            } else if (animal instanceof dog) {
                ++countDog;
                System.out.println("\n\t\tDog : " + countDog + animal.toString());
            } else if (animal instanceof cat) {
                ++countCat;
                System.out.println("\n\t\tCat : " + countCat + animal.toString());
            } else {
                ++countAnimal;
                System.out.println("\n\t\tAnimal other : " + countAnimal + animal.toString());
            }
        }
        return ds;

    }

    // ------------ them vat -----------
    public void chonAnimal(List<animal> danhsach) {
        int choose;
        int lenght ;
        while (true) {
            System.out.print("1. Tiger");
            System.out.println("\t\t2. Dog");
            System.out.print("3. Cat");
            System.out.print("4. Thoat\n");
            System.out.print("\nNhap lua chon: ");
            choose = sc.nextInt();
            sc.nextLine();
            lenght = danhsach.size();
            switch (choose) {
            case 1:
                danhsach.add(new tiger());
                break;
            case 2:
                danhsach.add(new dog());
                break;
            case 3:
                danhsach.add(new cat());
                break;

            case 4:
                break;

            default:
                System.out.println("Lua chon khong hop le");

            }
            if (choose == 4)
                break;
            danhsach.get(lenght).nhapTT();

        }
    }

    // ---------- nhap tt ------------
    Scanner sc = new Scanner(System.in);

    public void nhapTT() {

        System.out.println("Nhap ma chuong");
        maChuong = sc.nextLine();

        System.out.print("\nBan co muon them con vat khong? (Y/N) (y) :");
        String check = sc.nextLine();

        if (!"n".equalsIgnoreCase(check))
            chonAnimal(dsAnimal);

    }

    @Override
    public String toString() {
        return "Ma chuong = " + maChuong + dsAnimal;
    }

}
