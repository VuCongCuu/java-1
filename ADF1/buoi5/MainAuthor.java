package buoi5;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainAuthor {
	public static void main(String[] args) {
//		Author a=new Author();
//		a.nhaptt();
//		System.out.println("thong tin" +a);
Date now = new Date();
		
		System.out.println("now: "+ now);
		// 14/10/2021
		SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yy");
		System.out.println("now"+ sdf.format(now));
		Date date1;
		try {
			date1 = sdf.parse("20/06/2021");
			System.out.println(date1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
