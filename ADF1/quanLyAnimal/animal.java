package quanLyAnimal;

import java.util.Scanner;

public abstract class animal {
    protected String name;
    protected int tuoi;
    protected String description;

    // ------------- constructor ---------------

    public animal(String name, int tuoi, String description) {
        this.name = name;
        this.tuoi = tuoi;
        this.description = description;
    }

    public animal() {
    }

    public animal(String name, int tuoi) {
        this.name = name;
        this.tuoi = tuoi;
    }

    // ------------ set, get --------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ---------- mo rong ----------------

    public abstract String getTiengKeu();

    Scanner sc = new Scanner(System.in);

    public void nhapTT() {
        System.out.print("Nhap ten: ");
        name = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        tuoi = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap mo ta: ");
        description = sc.nextLine();

    }

    @Override
    public String toString() {
        return "\nName = " + name

                + " | Tuoi = " + tuoi

                + " | Mo ta = " + description

                + "Tieng keu = " + getTiengKeu();
    }

}

