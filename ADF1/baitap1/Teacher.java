package baitap1;

import java.util.Date;
import java.util.Scanner;

public class Teacher extends PerSonal{
    private String lopDay;
    private int luong;
    private int gioDay;

    public Teacher(){
        super();
    }

    public Teacher(String lopDay, int luong , int gioDay, String Name, String Gender, Date Birthday, String address){
        super(Name, Gender,Birthday,address);
        this.gioDay = gioDay;
        this.lopDay = lopDay;
        this.luong = luong;
    }

    public String getLopDay() {
        return lopDay;
    }

    public void setLopDay(String lopDay) {
        this.lopDay = lopDay;
    }

    public void setGioDay(int gioDay) {
        this.gioDay = gioDay;
    }

    public int getGioDay() {
        return gioDay;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }

    public int getLuong() {
        return luong;
    }

    @Override
    public int ThongTin(){
        super.ThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Lop day : ");
        this.lopDay = sc.nextLine();
        System.out.println("Gio day: ");
        this.gioDay = sc.nextInt();
        System.out.println("Luong: ");
        this.luong = sc.nextInt();
        if(Name == "T" && Name == "V" && Name == "A"){
            System.out.println("Ten bat dau bang T ,V , A");
            System.out.println("Luong thuc nhan la : " + (gioDay*(luong+50000)));
        } else if(Name == "L" && Name == "H" && Name == "S"){
            System.out.println("Ten bat dau bang L , H , S");
            System.out.println("Luong thuc nhan la : " + (gioDay*(luong - 20000)));
        } else {
            System.out.println("Ten khong co trong danh sach tang giam!");
            System.out.println("Luong thuc nhan la: " + (gioDay*luong));
        }
        return 0;
    }
}

