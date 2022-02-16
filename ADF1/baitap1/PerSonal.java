package baitap1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PerSonal {

    protected String Name;
    protected String Gender;
    protected Date Birthday;
    protected String Address;
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public PerSonal(){
        super();
    }

    public PerSonal(String Name, String Gender,Date Birthday,String address ){
        super();
        this.Name = Name;
        this.Gender = Gender;
        this.Address = Address;
        this.Birthday = Birthday;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getGender() {
        return Gender;
    }

    public void setAddress(String address) {
        this.Address = address;
    }

    public String getAddress() {
        return Address;
    }

    public void setBirthday(Date birthday) {
        this.Birthday = birthday;
    }

    public SimpleDateFormat getSdf() {
        return sdf;
    }

    public int ThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ten : ");
        this.Name = sc.nextLine();
        while (this.Birthday == null) {
            System.out.println("Ngay Sinh(dd/MM/yyyy): ");
            try {
                this.Birthday = sdf.parse(sc.nextLine());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        do{
            System.out.println("Gioi Tinh (m: nam , f : nu , o : Khac)");
            this.Gender = sc.nextLine();
        }while(!"m".equalsIgnoreCase(this.Gender) && !"f".equalsIgnoreCase(this.Gender) && !"b".equalsIgnoreCase(this.Gender));
        System.out.println("Dia Chi : ");
        this.Address = sc.nextLine();
        return 0;
    }

    @Override
    public String toString() {
        return "PerSonal{" +
                "Name='" + Name + '\'' +
                ", Gender=" + Gender +
                ", Birthday=" + sdf.format(Birthday) +
                ", Address='" + Address + '\'' +
                '}';
    }
}

