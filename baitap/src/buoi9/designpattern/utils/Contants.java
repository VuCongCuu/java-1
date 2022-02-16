package buoi9.designpattern.utils;

public class Contants {
	public static String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=t2104e";
	public static String username = "sa";
	public static String password = "123456";
	
	// Gia tri tra ve tuong ung voi resCode
	// thuc hien thanh cong
	public static final int RES_SUCCESS = 1;
	// thuc hien khong thanh cong
	public static final int RES_FAIL = 0;
	// tham so dau vao chua validate
	public static final int RES_NOT_VALIDATE = -1;
	// ket noi db khong thanh cong
	public static final int RES_NOT_CONNECT = -2;
}
