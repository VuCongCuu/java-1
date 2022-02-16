package thuchanh;

import java.util.ArrayList;
import java.util.Scanner;

public class chuongtrai {
	private String maChuong;
	private ArrayList<DongVat> dsDongVat;

	// ---------constructor------
	public chuongtrai() {
		this.dsDongVat = new ArrayList<DongVat>();
	}

	public chuongtrai(String maChuong, ArrayList<DongVat> dsDongVat) {
		super();
		this.maChuong = maChuong;
		this.dsDongVat = dsDongVat;
	}

	// --------set get------------
	public String getMaChuong() {
		return maChuong;
	}

	public void setMaChuong(String maChuong) {
		this.maChuong = maChuong;
	}

	public ArrayList<DongVat> getDsDongVat() {
		return dsDongVat;
	}

	public void setDsDongVat(ArrayList<DongVat> dsDongVat) {
		this.dsDongVat = dsDongVat;
	}

	// ----mo rong---------------
	public String KiemtraDongVat(ArrayList<DongVat> dsDongVat) {
		String ds = "";
		int countCho = 0;
		int counMeo = 0;
		int countDVkhac = 0;
		if (dsDongVat == null)
			return null;
		for (DongVat vat : dsDongVat) {
			if (vat instanceof Cho) {
				++countCho;
				System.out.println("Cho " + countCho + vat.toString());
			} else if (vat instanceof meo) {
				++counMeo;
				System.out.println("meo so: " + counMeo + vat.toString());
			} else {
				++countDVkhac;
				System.out.println("Dong vat khac:" + countDVkhac + vat.toString());
			}
		}
		return ds;
	}

	// ----them chuong-----------
	Scanner sc = new Scanner(System.in);

	public void themVat(ArrayList<DongVat> dongvat) {
		int chose=0;
		int leght=0;
		while (true) {
			System.out.println("lua cho dong van muon them:(1-cho;2-meo;3-thoat):");
			chose = sc.nextInt();
			leght = dongvat.size();
			switch (chose) {
			case 1:
				dongvat.add(new Cho());
				break;
			case 2:
				dongvat.add(new meo());
				break;
			case 3:
				System.exit(3);
				;
			}
			if (chose == 3) {
				break;
			}
			dongvat.get(leght).nhapTT();

		}
	}
	public void nhapTT() {
		System.out.println("nhap ma chuong");
		this.maChuong = sc.nextLine();
		System.out.println("ban co muon nhap tiep khong");
		String check=sc.nextLine();
		if(!"n".equalsIgnoreCase(check)) {
			themVat(dsDongVat);
		}
	}

	@Override
	public String toString() {
		return "chuongtrai [maChuong=" + maChuong + ", dsDongVat=" + dsDongVat + "]";
	}

}
