package thu_vien_2;

public class book extends documents {
    private String nameAuthor;
    private int soTrang;

    // ------- construct ---------------
    public book(String maTaiLieu, String nameTaiLieu, String nameNXB, int soBanPhatHanh, String nameAuthor,
            int soTrang) {
        super(maTaiLieu, nameTaiLieu, nameNXB, soBanPhatHanh);
        this.nameAuthor = nameAuthor;
        this.soTrang = soTrang;
    }

    public book() {

    }

    // --------- set, get ------------

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    // -------- mo rong -----------

    @Override
    public void NhapTT() {
        System.out.print("\nNhap thong tin sach: ");
        super.NhapTT();

        System.out.print("Nhap Ten tac gia: ");
        nameAuthor = sc.nextLine();

        System.out.print("Nhap Ten tac gia: ");
        nameAuthor = sc.nextLine();
    }

    @Override
    Double price() {
        return gia1TrangSach * soBanPhatHanh * soTrang * 1.0;
    }

    @Override
    public String toString() {
        return super.toString()

                + " | Ten tac gia = " + nameAuthor

                + " | So trang = " + soTrang;
    }

}
