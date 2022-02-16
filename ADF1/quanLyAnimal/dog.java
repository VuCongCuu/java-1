package quanLyAnimal;


import java.util.Scanner;

public class dog extends animal {

    private String chuNha;
    private String traiMo;

    // -------------- constructor ----------------

    public dog(String name, int tuoi, String description, String chuNha, String traiMo) {
        super(name, tuoi, description);
        this.chuNha = chuNha;
        this.traiMo = traiMo;
    }

    public dog() {
        super();
    }

    // -------------- mo rong -------------------
    Scanner sc = new Scanner(System.in);

    @Override
    public void nhapTT() {
        super.nhapTT();
        System.out.print("Ten chu nha: ");
        chuNha = sc.nextLine();

        System.out.print("Trai mo: ");
        traiMo = sc.nextLine();
    }

    @Override
    public String getTiengKeu() {
        return "gau...gau...gau...";

    }

    @Override
    public String toString() {
        return super.toString()

                + " | Chu Nha: " + chuNha

                + " | Trai Mo : " + traiMo;
    }

}
