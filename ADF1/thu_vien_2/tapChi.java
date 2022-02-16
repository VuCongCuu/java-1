
package thu_vien_2;

public class tapChi extends documents {
    private int soPhatHanh;
    private int thangPhatHanh;

    // ------- construct ---------------
    public tapChi(String maTaiLieu, String nameTaiLieu, String nameNXB, int soBanPhatHanh, int soPhatHanh,
            int thangPhatHanh) {
        super(maTaiLieu, nameTaiLieu, nameNXB, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public tapChi() {

    }

    // --------- set, get ------------

    public int getNameAuthor() {
        return soPhatHanh;
    }

    public void setNameAuthor(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getthangPhatHanh() {
        return thangPhatHanh;
    }

    public void setthangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    // -------- mo rong -----------

    @Override
    public void NhapTT() {
        System.out.print("\nNhap thong tin tap chi: ");
        super.NhapTT();

        System.out.print("Nhap so phat hanh: ");
        soPhatHanh = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhap Thang phat hanh: ");
        thangPhatHanh = sc.nextInt();
    }

    @Override
    Double price() {
        if (thangPhatHanh > 11) {
            return giaTapChi * soBanPhatHanh * 2.0;

        }
        return giaTapChi * soBanPhatHanh * 1.0;
    }

    @Override
    public String toString() {
        return super.toString()

                + " | So phat hanh = " + soPhatHanh

                + " | Thang phat hanh = " + thangPhatHanh;
    }

}
