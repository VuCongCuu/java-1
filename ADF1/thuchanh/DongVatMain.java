package thuchanh;

import java.util.ArrayList;

public class DongVatMain {
	public static void main(String[] args) {
		ArrayList<DongVat> chuong_1= new ArrayList<DongVat>();
		chuong_1.add(new Cho("lulu", 2, "hay can nguoi", "Cuu", "pitpun"));
		chuong_1.add(new Cho("linhky", 3, "hay can nguoi", "Duc", "pitpun"));
		chuong_1.add(new meo("meomeo", 1, "can nguoi", "cucu", "acs"));
		chuong_1.add(new meo("mun", 1, "can nguoi", "cucu", "acs"));
		
		ArrayList<DongVat> chuong_2=new ArrayList<DongVat>();
		chuong_2.add(new Cho("lulu", 9, "hay can nguoi", "Cuu", "pitpun"));
		chuong_2.add(new Cho("linhky", 8, "hay can nguoi", "Duc", "pitpun"));
		chuong_2.add(new meo("meomeo", 7, "can nguoi", "cucu", "acs"));
		chuong_2.add(new meo("mun", 6, "can nguoi", "cucu", "acs"));
		
		ArrayList<chuongtrai> dsChuong= new ArrayList<chuongtrai>();
		dsChuong.add(new chuongtrai("chuong1", chuong_1));
		dsChuong.add(new chuongtrai("chuong2", chuong_2));
		
		Zoo zoo=new Zoo();
		zoo.showdv(dsChuong);
	}
		
}
