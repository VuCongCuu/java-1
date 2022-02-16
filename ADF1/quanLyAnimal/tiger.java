package quanLyAnimal;

import java.util.Scanner;

public class tiger extends animal {
    private String khuRung;
    private String rapXiec;

    // -------------- constructor ----------------

    public tiger(String name, int tuoi, String description, String khuRung, String rapXiec) {
        super(name, tuoi, description);
        this.khuRung = khuRung;
        this.rapXiec = rapXiec;
    }

    public tiger() {
        super();
    }

    // -------------- mo rong -------------------
    Scanner sc = new Scanner(System.in);

    @Override
    public void nhapTT() {
        super.nhapTT();
        System.out.print("Ten khu rung: ");
        khuRung = sc.nextLine();

        System.out.print("Rap xiec: ");
        rapXiec = sc.nextLine();
    }

    @Override
    public String getTiengKeu() {
        return "gram...gram...gram...";

    }

    @Override
    public String toString() {
        return super.toString()

                + " | Rung tu nhien: " + khuRung

                + " | Rap xiec : " + rapXiec;
    }

}

