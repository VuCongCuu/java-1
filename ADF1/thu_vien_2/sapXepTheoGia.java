package thu_vien_2;

import java.util.Comparator;

public class sapXepTheoGia implements Comparator<documents> {

    @Override
    public int compare(documents arg0, documents arg1) {
        int soSanh = arg1.price().compareTo(arg0.price());
        return soSanh;
    }

    // private documents documents = new documents();
    // @Override
    // public int compare(String , documents arg1) {

    // return 0;
}
