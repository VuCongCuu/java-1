package buoi5;

public class MainSinhVien {
	public static void main(String[] args) {
		SinhVien a=new SinhVien();
		a.nhapttSinhVien();
		System.out.println(a);
		if(a.getTb()>=9) {
			a.gioi();
		} else if(a.getTb()>=7) {
			a.kha();
		} else if(a.getTb()>=5) {
			a.tb();
		} else {
			a.yeu();
		}
		
	}
}
