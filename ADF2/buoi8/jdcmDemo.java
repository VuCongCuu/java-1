package buoi8;



import java.sql.SQLException;


import java.util.List;

public class jdcmDemo {
	public static void main(String[] args) throws SQLException {
		BookDao dao = new BookDao();
//		System.out.println((dao.insertBook(1, "conan", 1000))==true?"thanh cong":"that bai");
//		System.out.println((dao.insertBook(2, "conan2", 2000))==true?"thanh cong":"that bai");
////		System.out.println((dao.insertBook(3, "conan3", 3000))==true?"thanh cong":"that bai");
////		System.out.println(dao.deletebook(2));
//		ResponseObject res=dao.updateBook(3,"conna45", 99999);
//		System.out.println("Update code:" +res.errCode+"desc: "+res.errDesc);
	List<Book> list=dao.getList();
	for(Book csxd: list ) {
		System.out.println(csxd);
	}
	
	}
}
