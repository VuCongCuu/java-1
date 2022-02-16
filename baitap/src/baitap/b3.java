package baitap;

public class b3 {
	public static void main(String[] args) {
		String s1 = "java string split method by viettuts";
		String[] s2=s1.split(" ");
		for(String a:s2) {
			System.out.println(a);
		}
		System.out.println(s2[0]);
		System.out.println(s2[5]);
	}	
}
