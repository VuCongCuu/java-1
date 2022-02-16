package buoi6;

public class Ex {
	public static void main(String[] args) {
		String[][] toaNha = new String[5][5];
		toaNha[0][0]="A11";
		for(int i=0;i<toaNha.length;i++) {
			String tang[]=toaNha[i];
			for(int j=0;j<tang.length;j++) {
				toaNha[i][j]="A"+(i+1)+(j+1);
			}
		}
		for(String[]nha : toaNha) {
			for(String can : nha) {
				System.out.print(can + " ");
			}
			System.out.println();
		}
		
	}
}
