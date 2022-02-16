package thu_vien_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public abstract class documents implements Comparable<documents> {
    protected String maTaiLieu;
    protected String nameTaiLieu;
    protected String nameNXB;
    protected int soBanPhatHanh;
    protected final int gia1TrangSach = 1000;
    protected final int giaBao = 10000;
    protected final int giaTapChi = 5000;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // ----------- constructor ---------------
    public documents(String maTaiLieu, String nameTaiLieu, String nameNXB, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.nameTaiLieu = nameTaiLieu;
        this.nameNXB = nameNXB;
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public documents() {
    }

    // ----------- set, get -----------

    public String getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(String maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getNameTaiLieu() {
        return nameTaiLieu;
    }

    public void setNameTaiLieu(String nameTaiLieu) {
        this.nameTaiLieu = nameTaiLieu;
    }

    public String getNameNXB() {
        return nameNXB;
    }

    public void setNameNXB(String nameNXB) {
        this.nameNXB = nameNXB;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    // ------- mo rong ---------

    @Override
    public int compareTo(documents arg0) {
        int soSanh = Integer.valueOf(this.getSoBanPhatHanh()).compareTo(arg0.getSoBanPhatHanh());
        return soSanh;
    }

    public Date checkNgay(String yeuCau) {
        Date ngay = new Date();

        while (true) {
            System.out.print("Nhap " + yeuCau + " (dd/MM/yyyy)");
            try {
                ngay = sdf.parse(sc.nextLine());
                return ngay;
            } catch (ParseException e) {
                System.out.println("Nhap sai dinh dang ngay");
            }
        }

    }

    abstract Double price();

    Scanner sc = new Scanner(System.in);

    public void NhapTT() {
        System.out.print("Ma tai lieu: ");
        maTaiLieu = sc.nextLine();

        System.out.print("Ten tai lieu: ");
        nameTaiLieu = sc.nextLine();

        System.out.print("Ten nha xuat ban: ");
        nameNXB = sc.nextLine();

        System.out.print("So ban phat hanh: ");
        soBanPhatHanh = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "\nMa tai lieu = " + maTaiLieu

                + " | Ten tai lieu = " + nameTaiLieu

                + " | Ten NXB = " + nameNXB

                + " | So ban phat hanh = " + soBanPhatHanh

                + " | Tong doanh thu = " + price();
    }

}
