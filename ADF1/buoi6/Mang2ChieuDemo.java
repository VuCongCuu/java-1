package buoi6;

public class Mang2ChieuDemo {
public static void main(String[] args) {
	String[][] toAnBinh=new String[10][5];
	//gan gia tri
	toAnBinh[0][0]="A11";
	//duyet
			for(int i=0;i<toAnBinh.length;i++) {
				String[] tang=toAnBinh[i];
				for(int j=0;j<tang.length;j++) {
					toAnBinh[i][j]="A"+(i+1)+(j+1);
				}
			}
	for(String[] tang :toAnBinh) {
		for(String canHo : tang) {
			System.out.print(canHo+" ");
		}
		System.out.println();
	}
}
}
