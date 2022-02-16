package baitap1;

import java.util.Date;
import java.util.Scanner;

public class Student extends PerSonal{
    private String maSv;
    private float diemTb;
    private String email;

    public Student(){
        super();
    }
    public Student(String maSv , float diemTb, String email, String Name, String Gender, Date Birthday, String address){
        super(Name, Gender,Birthday,address);
        this.maSv = maSv;
        this.diemTb=diemTb;
        this.email=email;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public float getDiemTb() {
        return diemTb;
    }

    public void setDiemTb(float diemTb) {
        this.diemTb = diemTb;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    Scanner sc = new Scanner(System.in);
@Override
    public int ThongTin(){
        super.ThongTin();
        System.out.println("Ma Sinh Vien: ");
        this.maSv = sc.nextLine();
        System.out.println("Email: ");
        this.email = sc.nextLine();
            System.out.println("Diem");
            this.diemTb = sc.nextFloat();
        if(diemTb < 5){
            System.out.println("Yeu!");
        } else if(diemTb > 5 && diemTb < 7){
            System.out.println("Trung Binh!");
        } else if(diemTb >7 && diemTb <9){
            System.out.println("Kha!");
        } else if(diemTb > 9){
            System.out.println("Gioi");
        } else if(diemTb > 10 && diemTb < 0) {
            System.out.println("Diem khong hop le!");
        }
    return 0;


}

    @Override
    public String toString() {
        return "Student{" +super.toString() +
                "maSv='" + maSv + '\'' +
                ", diemTb=" + diemTb +
                ", email='" + email + '\'' +
                '}';
    }

}

