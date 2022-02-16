package buoi1;

public class ThrowsDemo {
	public static void main(String[] args) {
		String produc = "DT,DT13";
		validateProduc(produc);
	}
	public static void validateProduc(String producstr) {
		if(producstr==null||"".equals(producstr)) {
			System.out.println("Tham so dau vao rong");
		} else if(producstr.indexOf(",")<0) {
			System.out.println("tham so dau khong dung");
		} else {
			String[] arr_produc= producstr.split(",");
			if(arr_produc.length!=5) {
				System.out.println("dau vao khong phai 1 sp");
			}
		}
	}
}
