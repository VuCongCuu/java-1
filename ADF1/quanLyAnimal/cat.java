package quanLyAnimal;

import java.util.Scanner;

public class cat extends animal {
    private String chuNha;
    private String spa;

    // -------------- constructor ----------------

    public cat(String name, int tuoi, String description, String chuNha, String spa) {
        super(name, tuoi, description);
        this.chuNha = chuNha;
        this.spa = spa;
    }

    public cat() {
        super();
    }

    // -------------- mo rong -------------------
    Scanner sc = new Scanner(System.in);

    @Override
    public void nhapTT() {
        super.nhapTT();
        System.out.print("Ten chu nha: ");
        chuNha = sc.nextLine();

        System.out.print("Spa: ");
        spa = sc.nextLine();
    }

    @Override
    public String getTiengKeu() {
        return "meo...meo...meo...";

    }

    @Override
    public String toString() {
        return super.toString()

                + " | Chu Nha: " + chuNha

                + " | spa : " + spa;
    }

}

