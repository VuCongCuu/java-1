package Assignment2_Variable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class Constrain {
	
	public static String url;
	public static String userDB;
	public static String passwordDB;
	
	public static final String EXTRACT_FILE_WORD ="Extract"; 

	
	//Account Type Final Variable
	public static final int TYPE_ACCOUNT_VISA = 1;
	public static final int TYPE_ACCOUNT_DEFAULT = 0;
	//File Path
	public static final String URL_EXTRACT_FILE_DEFAUL ="D:\\Java_workspace\\Java_SelfStudy\\src\\AssignStore\\Assign_Default";
	public static final String URL_EXTRACT_FILE_VISA ="D:\\Java_workspace\\Java_SelfStudy\\src\\AssignStore\\Assign_Visa";
	public static final String URL_FILE_READY_READ ="D:\\Java_workspace\\Java_SelfStudy\\src\\AssignStore\\File_Store";
	//Date & Time Format
	public static SimpleDateFormat dateFormated = new SimpleDateFormat("dd/MM/yyyy");
	public static SimpleDateFormat monthFormated = new SimpleDateFormat("MM-yyyy");
	
	//List Location Random
	public static List<String> LIST_PLACE_TRANSACTION = new ArrayList<String>(Arrays.asList("Internet Bank","Dong Da, HaNoi","Hoang Mai, HaNoi","Cau Giay, HaNoi","Ba Dinh, HaNoi","Long Bien, HaNoi"));
	
	public static void loadConfig() {
		ResourceBundle rs = ResourceBundle.getBundle("Assignment2_Variable.Config");
		if(rs.containsKey("database_url")) {
			url = rs.getString("database_url");
		}else {
			url ="jdbc:sqlserver://127.0.0.1:1433;databaseName=Assignment2";
		}
		if(rs.containsKey("database_userDB")) {
			userDB = rs.getString("database_userDB");
		}else {
			userDB = "hieunguyen";
		}
		if(rs.containsKey("database_passwordBD")) {
			passwordDB = rs.getString("database_passwordBD");
		}else {
			passwordDB ="123456";
		}
	}
	
	public static String getRandomPlace() {
		  Random ran = new Random();
	      int ranNum = ran.nextInt(LIST_PLACE_TRANSACTION.size());
	      return LIST_PLACE_TRANSACTION.get(ranNum);
	}
}
