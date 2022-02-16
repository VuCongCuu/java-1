package thu_vien_2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class bao extends documents {

    private Date ngayPhatHanh;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // ------- construct ---------------

    public bao(String maTaiLieu, String nameTaiLieu, String nameNXB, int soBanPhatHanh, String ngayPhatHanh) {
        super(maTaiLieu, nameTaiLieu, nameNXB, soBanPhatHanh);
        try {
            this.ngayPhatHanh = sdf.parse(ngayPhatHanh);
        } catch (ParseException e) {
            this.ngayPhatHanh = new Date();
        }
    }

    public bao() {

    }

    // --------- set, get ------------

    public String getNgayPhatHanh() {
        return sdf.format(ngayPhatHanh);
    }

    public void setNgayPhatHanh(String ngayPhatHanh) {
        try {
            this.ngayPhatHanh = sdf.parse(ngayPhatHanh);
        } catch (ParseException e) {
            this.ngayPhatHanh = new Date();
        }
    }

    // -------- mo rong -----------

    @Override
    public void NhapTT() {
        System.out.print("\nNhap thong tin bao: ");
        super.NhapTT();

        ngayPhatHanh = checkNgay("ngay phat hanh");
    }

    @Override
    Double price() {
        Date now = new Date();
        long soNgay = now.getTime() - ngayPhatHanh.getTime();
        soNgay = soNgay / (1000 * 60 * 60 * 24);
        return soNgay * giaBao * soBanPhatHanh * 1.0;
    }

    @Override
    public String toString() {
        return super.toString()

                + " | Ngay phat hanh = " + getNgayPhatHanh();
    }

}