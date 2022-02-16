package Assignment2_Dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import Assignment2_Obj.Customer;
import Assignment2_Variable.Constrain;
import Assignment2_Variable.DBconnection_Assignment2;
import Assignment2_Variable.ValidateField;

public class CustomerDao {
	
	//Menu Customer
	public static void menuCustomer() {
		String confirm = "";
		Boolean flag = false;
		Scanner sct = new Scanner(System.in);
			do {
				try{
				System.out.println("----- MENU CUSTOMER -----");
				System.out.println("--------------------------");
				System.out.println("1: ADD NEW CUSTOMER");
				System.out.println("2: UPDATE 1 CUSOMTER BY CUSTOMER NUMBER");
				System.out.println("3: DELETE 1 CUSTOMER BY CUSTOMER NUMBER");
				System.out.println("4: SHOW A LIST CUSTOMERS");
				System.out.println("5: FIND 1 CUSTOMER BY CUSTOMER NUMBER");
				System.out.println("6: FIND 1 CUSTOMER BY NAME GET FROM KEYBOARD");
				System.out.println("7: FIND LIST CUSTOMER BIRTHDAY IN MONTH GET FROM KEYBOARD");
				System.out.println("8: EXTRACT LIST CUSOMTER TO FILE");
				System.out.println("9: ADD LIST CUSTOMER TO DB FROM FILE");
				System.out.println("10: EXIT");
				System.out.print("ENTER CHOOSE: ");
				int choose = sct.nextInt();
				switch(choose) {
				case 1:
					addCustomerDB();
					break;
				case 2:
					updateCustomerDB();
					break;
				case 3:
					deleteCustomerDB();
					break;
				case 4:
					showListCustomer("");
					break;
				case 5:
					FindCus();
					break;
				case 6:
					FindListByName();
					break;
				case 7:
					FindCusBirthday();
					break;
				case 8:
					showListCustomer("Extract");
					break;
				case 9:
					chooseAddFile();
					break;
				case 10:
					flag = true;
					break;
				default:
					System.out.println("PLEASE CHOOSE FOLLOW BY INSTRUTOR");
					break;
				}
				if(!flag) {
					System.out.print("DO YOU WANT TO CONTINUE WORK WITH MENU CUSTOMER(n:EXIT): ");
					confirm = sct.nextLine();
				}
			}catch(Exception e){
				System.out.println("Error Found Menu Customer " + e.getMessage());
			}
				sct.nextLine();
			}while(!confirm.equalsIgnoreCase("n") && !flag);
	}
	//Method Create New Customer 
	private static void addCustomerDB() {
		//B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Connection Error");
		}
		//B2:Create SQL
		String sql = "Insert Into KhachHang(Cus_Num,Cus_Name,Cus_Identity,PhoneNum,Email,Birthdate,Gender,Address_home,Cus_Type) Values(?,?,?,?,?,CONVERT(date,?, 103),?,?,?)";
		Customer newCust = new Customer();
		newCust.addInfoCustomer();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, newCust.getCus_Num());
			ps.setString(2, newCust.getCus_Name());
			ps.setString(3, newCust.getCus_Identity());
			ps.setString(4, newCust.getPhoneNumber());
			ps.setString(5, newCust.getEmail());
			ps.setString(6, newCust.getBirthdate());
			ps.setInt(7, newCust.getGender());
			ps.setString(8, newCust.getAddress());
			ps.setInt(9, newCust.getCus_Type());
			int run = ps.executeUpdate();
			ps.close();
			//B3:Result
			if(run == 0) {
				System.out.println("Please Check Again");
			}else {				
				System.out.println("Insert Successfully");
			}
		} catch (SQLException e) {
			System.out.println("Error Found Add Customer "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	//Method Update 1 Customer By Customer Number
	private static void updateCustomerDB() {
		//B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Connection Error");
		}
		//B2:Create SQL
		String sql ="Exec updateCus ?,?,?,?,?,?,?,?,?,?,?";
		Customer newCust = new Customer();
		newCust.addInfoCustomer();
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, newCust.getCus_Num());
			cs.setString(2, newCust.getCus_Name());
			cs.setString(3, newCust.getCus_Identity());
			cs.setString(4, newCust.getPhoneNumber());
			cs.setString(5, newCust.getEmail());
			cs.setString(6, newCust.getBirthdate());
			cs.setInt(7, newCust.getGender());
			cs.setString(8, newCust.getAddress());
			cs.setInt(9, newCust.getCus_Type());
			
			cs.registerOutParameter(10, Types.INTEGER);
			cs.registerOutParameter(11, Types.NVARCHAR);
			cs.executeUpdate();
			int res_sign = cs.getInt(10);
			String mess = cs.getString(11);
			cs.close();
			//B3:Result
			if(res_sign == 0) {
				System.out.println(mess);
			}else {
				System.out.println(mess);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	//Method Delete 1 Customer By Customer Number -> If Customer Already Have Account -> Can't Delete -> Create Store Procedure
	private static void deleteCustomerDB() {
		//B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Connection Error");
		}
		//B2:Create SQL
		String sql = "Exec deleteCus ?,?,?";
		Scanner scc = new Scanner(System.in);
		try{
			System.out.print("Enter Customer Number Need Delete: ");
			String mafind = scc.nextLine();
			if(mafind == null) {
				System.out.println("Please Don't Let Customer Number Empty!");
				return;
			}
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, mafind);
			cs.registerOutParameter(2, Types.INTEGER);
			cs.registerOutParameter(3, Types.NVARCHAR);
			cs.executeUpdate();
			int res_sign = cs.getInt(2);
			String res_mess = cs.getString(3);
			cs.close();
			//B3:Result
			if(res_sign == 0) {
				System.out.println(res_mess);
			}else {
				System.out.println(res_mess);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	//Method Show List Customer In DataBase
	private static void showListCustomer(String type) {
		//B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Connection Error");
		}
		//B2:Create SQL
		String sql ="Select Id, Cus_Num,Cus_Name,Cus_Identity,PhoneNum,Email,Birthdate,Gender,Address_home,Cus_Type From KhachHang";
		//Using Lambda Expression
		changeType changeGender = (int t)->{
			if(t == 0) {return "Female";
			}else if(t == 1) {return "Male";
			}else if(t == 2) {return "Other";
			}else {return null;}};
		changeType changeType = (int t)->{
			if(t == 0) {return "Normal Customer";
			}else if(t == 1) {return "Vip Customer";
			}else {return null;}};
			
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean flag = true;
			boolean inFile = true;
			String nameFile = null;
			while(rs.next()) {
				//Show List Customer
				if(type == "") {
					if(flag) {flag = false;titleList();}
					System.out.format("%5d",rs.getInt(1));
					System.out.format("%10s",rs.getString(2));
					System.out.format("%18s",rs.getString(3));
					System.out.format("%14s",rs.getString(4));
					System.out.format("%19s",rs.getString(5));
					System.out.format("%30s",rs.getString(6));
					System.out.format("%18s",covertDateSQL(rs.getDate(7)));
					System.out.format("%10s",changeGender.changeTypeDL(rs.getInt(8)));
					System.out.format("%20s",rs.getString(9));
					System.out.format("%20s",changeType.changeTypeDL(rs.getInt(10)));
					System.out.println();				
				}
				//Extract List Customer
				String line = String.valueOf(rs.getInt(1))+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+rs.getString(4)+" , "+rs.getString(5)+" , "+rs.getString(6)+" , "+covertDateSQL(rs.getDate(7))+" , "+changeGender.changeTypeDL(rs.getInt(8))+" , "+rs.getString(9)+" , "+changeType.changeTypeDL(rs.getInt(10))+"\n";
				if(type.equalsIgnoreCase(Constrain.EXTRACT_FILE_WORD) && inFile) {
					inFile = false;
					flag = false;
					nameFile = createFile();
				}
				//->Call To Write File
				if(!inFile)readFile(nameFile,line);
			}
			if(flag) System.out.println("Data Is Updating");
			if(!inFile)System.out.println("Extract File Successfully");	
			ps.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error Found Show List Cust "+e.getMessage());
		}
		 DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	//Create File 
	private static String createFile() {
		Scanner sc = new Scanner(System.in);
		File filenew = null;
		while(true) {
			System.out.print("Enter Name File(Include Extention Name): ");
			String nameFile = sc.nextLine();
			filenew = new File(Constrain.URL_FILE_READY_READ+"\\"+nameFile);
			try {
				if(filenew.createNewFile()) {
					break;
				}else {
					System.out.println("File Is Already Exist");
					System.out.print("Do You Want To Continue Extract Into This File?(n:Exit): ");
					String confirm = sc.nextLine();
					if(!confirm.equalsIgnoreCase("n")) {
						break;
					}
				}
			} catch (IOException e) {
				System.out.println("Error Found Create File "+e.getMessage());
			}	
		}
		return filenew.getAbsolutePath();
	}
	//Read File By Line
	private static void readFile(String filepath,String line) {
		File file = new File(filepath);
		try(
				FileWriter wr = new FileWriter(file,true);
				BufferedWriter br = new BufferedWriter(wr);
				PrintWriter pw = new PrintWriter(br);
				) {
				pw.write(line);
				pw.flush();
		} catch (IOException e) {
			System.out.println("Error Found Write File "+e.getMessage());
		}
	}
	
	//Method Find Customer By Customer Number
	private static void FindCus() {
		Scanner ca = new Scanner(System.in);
		//B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		//B2:Create SQL
			String sql = "Select Id, Cus_Num,Cus_Name,Cus_Identity,PhoneNum,Email,Birthdate,Gender,Address_home,Cus_Type From KhachHang Where Cus_Num = ?";
			System.out.print("Enter Customer Number: ");
			String makh = ca.nextLine();
			changeType changeGender = (int t)->{
				if(t == 0) {return "Female";
				}else if(t == 1) {return "Male";
				}else if(t == 2) {return "Other";
				}else {return null;}};
			changeType changeType = (int t)->{
				if(t == 0) {return "Normal Customer";
				}else if(t == 1) {return "Vip Customer";
				}else {return null;}};
				
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, makh);
				ResultSet rs = ps.executeQuery();
				boolean flag = true;
				while(rs.next()) {
					if(flag) {flag = false;titleList();}
					System.out.format("%5d",rs.getInt(1));
					System.out.format("%10s",rs.getString(2));
					System.out.format("%18s",rs.getString(3));
					System.out.format("%14s",rs.getString(4));
					System.out.format("%19s",rs.getString(5));
					System.out.format("%30s",rs.getString(6));
					System.out.format("%18s",covertDateSQL(rs.getDate(7)));
					System.out.format("%10s",changeGender.changeTypeDL(rs.getInt(8)));
					System.out.format("%20s",rs.getString(9));
					System.out.format("%20s",changeType.changeTypeDL(rs.getInt(10)));
					System.out.println();
				}
				rs.close();
				ps.close();
				if(flag)System.out.println("The Customer Number Have No Data! Please Check Customer Again");
			} catch (SQLException e) {
				System.out.println("Error Found Find Customer  "+e.getMessage());
			}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	//Method Get Customer Have Birthday From Input MM
	private static void FindCusBirthday() {
		Scanner sc = new Scanner(System.in);
		//B1: Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		//B2:Create SQL
		String sql = "Select Id, Cus_Num,Cus_Name,Cus_Identity,PhoneNum,Email,Birthdate,Gender,Address_home,Cus_Type From KhachHang Where Month(Birthdate) = ?";
		String bday = null;
		while(true) {
			System.out.print("Enter Month Want To Find Birthday: ");
			bday = sc.nextLine();
			if(ValidateField.isValidMonthBitFormat(bday)) {
				break;
			}else {
				System.out.println("Please Enter Month Follow By Format MM");
			}
		}
		changeType changeGender = (int t)->{
			if(t == 0) {return "Female";
			}else if(t == 1) {return "Male";
			}else if(t == 2) {return "Other";
			}else {return null;}};
		changeType changeType = (int t)->{
			if(t == 0) {return "Normal Customer";
			}else if(t == 1) {return "Vip Customer";
			}else {return null;}};
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(bday));
			ResultSet rs = ps.executeQuery();
			boolean flag = true;
			while(rs.next()) {
				if(flag) {flag = false;titleList();};
				System.out.format("%5d",rs.getInt(1));
				System.out.format("%10s",rs.getString(2));
				System.out.format("%18s",rs.getString(3));
				System.out.format("%14s",rs.getString(4));
				System.out.format("%19s",rs.getString(5));
				System.out.format("%30s",rs.getString(6));
				System.out.format("%18s",covertDateSQL(rs.getDate(7)));
				System.out.format("%10s",changeGender.changeTypeDL(rs.getInt(8)));
				System.out.format("%20s",rs.getString(9));
				System.out.format("%20s",changeType.changeTypeDL(rs.getInt(10)));
				System.out.println();
			}
			//B3:Result
			rs.close();
			ps.close();
			if(flag)System.out.println("No One Has Birthday In This Month");
		} catch (SQLException e) {
			System.out.println("Error Found Find Birthday Cust "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	//Method Get Customer By Name
	private static void FindListByName() {
		Scanner sc = new Scanner(System.in);
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		//B2:Create SQL
		String sql = "Select Id,Cus_Num,Cus_Name,Cus_Identity,PhoneNum,Email,Birthdate,Gender,Address_home,Cus_Type From KhachHang Where Cus_Name Like(?)";
		String name = null;
		while(true) {
			System.out.print("Enter FirstName Find: ");
			name = sc.nextLine();
			if(name == null) {
				System.out.println("Please Don't Empty FirstName");
			}else {
				break;
			}
		}
		changeType changeGender = (int t)->{
			if(t == 0) {return "Female";
			}else if(t == 1) {return "Male";
			}else if(t == 2) {return "Other";
			}else {return null;}};
		changeType changeType = (int t)->{
			if(t == 0) {return "Normal Customer";
			}else if(t == 1) {return "Vip Customer";
			}else {return null;}};
			
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,"%"+name+"%");
			ResultSet rs = ps.executeQuery();
			boolean flag = true;
			while (rs.next()) {
				if(flag) {flag = false; titleList();};
				System.out.format("%5d",rs.getInt(1));
				System.out.format("%10s",rs.getString(2));
				System.out.format("%18s",rs.getString(3));
				System.out.format("%14s",rs.getString(4));
				System.out.format("%19s",rs.getString(5));
				System.out.format("%30s",rs.getString(6));
				System.out.format("%18s",covertDateSQL(rs.getDate(7)));
				System.out.format("%10s",changeGender.changeTypeDL(rs.getInt(8)));
				System.out.format("%20s",rs.getString(9));
				System.out.format("%20s",changeType.changeTypeDL(rs.getInt(10)));
				System.out.println();
			}
			//B3:Result
			rs.close();
			ps.close();
			if(flag) {System.out.println("This Name Have Not Found");}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Error Found Find Cus Name "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	//Method Extract File
	private static void chooseAddFile() throws SQLException {
		Scanner scan = new Scanner(System.in);
		//List File
		listFileReady(); 
		//Get Name File
		System.out.print("Enter Name File To Add: ");
		String name = scan.nextLine();
		boolean flag = false;
		File filestore = new File(Constrain.URL_FILE_READY_READ);
		if(filestore.isDirectory()) {
			File[] dsFiles = filestore.listFiles();
			for(File fl : dsFiles) {
				if(fl.getName().equalsIgnoreCase(name)) {
					flag = true;
					//Add List Customer -> Add
					addListCus(getListCus(fl.getAbsolutePath()));
					break;
				}
			}
		}
		if(!flag)System.out.println("File Name Is Not Match Any File In Folder");
	}
	//Method Add List Customer From File
	private static void addListCus(ArrayList<Customer> cus) throws SQLException {
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		con.setAutoCommit(false);
		//B2:Create SQL
		String sql = "Insert Into KhachHang(Cus_Num,Cus_Name,Cus_Identity,PhoneNum,Email,Birthdate,Gender,Address_home,Cus_Type) Values(?,?,?,?,?,CONVERT(date,?, 103),?,?,?)";
		boolean flag = true;
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			for(Customer cu :  cus) {
				if(flag ) {flag=false;};
				ps.setString(1, cu.getCus_Num());
				ps.setString(2, cu.getCus_Name());
				ps.setString(3, cu.getCus_Identity());
				ps.setString(4, cu.getPhoneNumber());
				ps.setString(5, cu.getEmail());
				ps.setString(6, cu.getBirthdate());
				ps.setInt(7, cu.getGender());
				ps.setString(8, cu.getAddress());
				ps.setInt(9, cu.getCus_Type());
				ps.addBatch();
			}
			int[] run = ps.executeBatch();
			if(flag)System.out.println("Error Insert");
			//B3:Result
			ps.close();
			con.commit();
			con.rollback();
		} catch (SQLException e) {
			System.out.println("Error Found Add List  "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	public static void listFileReady() {
		File filestore = new File(Constrain.URL_FILE_READY_READ);
		if(filestore.isDirectory()) {
			File[] dsFiles = filestore.listFiles();
			for(File fl : dsFiles) {
				System.out.println(fl.getName());
			}
		}
	}
	//Method Create List Customer
	private static ArrayList<Customer> getListCus(String filePath){
		ArrayList<Customer> listcus = new ArrayList<Customer>();
		try(BufferedReader rd = new BufferedReader(new FileReader(filePath));){
			String line = rd.readLine();
			while(line != null) {
				System.out.println(line);
				Customer cust = convertToCus(line);
				if(cust != null) {
					listcus.add(cust);
				}
				line =  rd.readLine();
			}
		}catch(IOException e) {
			System.out.println("Error Found Read File "+e.getMessage());
		}
		return listcus;
	}
	
	//Method Covert Line To Object
	private static Customer convertToCus(String line) {
		Customer cusnew = null;
		boolean flag = true;
		try {
			valideFieldCus(line);
		} catch (Exception e) {
			flag = false;
			System.out.println("Error Found Validate Field  "+e.getMessage());
		}
		if(flag) {
			String[] arrLine = line.split(",");
			Date date_cv = null;
			try {
				date_cv = Constrain.dateFormated.parse(arrLine[5]);
			} catch (ParseException e) {
				System.out.println("Error Found ConvertDate  "+e.getMessage());
			}
			cusnew = new Customer(
					arrLine[0],
					arrLine[1],
					arrLine[2],
					arrLine[3],
					arrLine[4],
					date_cv,
					Integer.parseInt(arrLine[6]),
					arrLine[7],
					Integer.parseInt(arrLine[8])
					);
		}
		return cusnew;
	}
	
	//Method Validate Field
	private static void valideFieldCus(String line) throws Exception {
		if(line == null) {
			throw new Exception("INPUT IS EMPTY");
		}
		String[] arrLine = line.split(",");
		System.out.println(arrLine.length);
		if(arrLine.length != 9) {
			throw new Exception("INPUT IS MISSING");
		}else {
			if(!ValidateField.isValidCusNumber(arrLine[0])) {
				throw new Exception("Customer Number Must Be 7 Characters And Not Contain Space");
			}
			if(!ValidateField.isValidUserName(arrLine[1])) {
				throw new Exception("Name At Least 6 Characters, Start With Character, Maximum 50 Characters, Not Null");
			}
			if(!ValidateField.isValidIdentity(arrLine[2])) {
				throw new Exception("Customer Identity Have 6 Characters And This Must Be Digits");
			}
			if(!ValidateField.isValidPhoneNum(arrLine[3])) {
				throw new Exception("Phone Number Have 10 Digists");
			}
			if(!ValidateField.isValidEmail(arrLine[4])) {
				throw new Exception("Email Must Follow By Example: example@gmail.com");
			}
			if(!ValidateField.isValidDateFormat(arrLine[5])) {
				throw new Exception("Birthdate Must Follow By Format dd/MM/yyyy");
			}
			if(!ValidateField.isValidGender(Integer.parseInt(arrLine[6]))) {
				throw new Exception("This Gender Is Not Correct");
			}
			if(arrLine[7].length() < 5 || arrLine[7] == null) {
				throw new Exception("Address At Least 5 Characters Require And Not Null");
			}
			if(!ValidateField.isValidCusType(Integer.parseInt(arrLine[8]))) {
				throw new Exception("Customer Type Must Be 0:Female Or 1: Male");
			}
		}
	}
	//Method Generate Table Title
	private static void titleList() {
		System.out.format("%5s","Id");
		System.out.format("%10s","Cus_Num");
		System.out.format("%15s","Cus_Name");
		System.out.format("%20s","Cus_Identity");
		System.out.format("%15s","PhoneNum");
		System.out.format("%20s","Email");
		System.out.format("%28s","Birthdate");
		System.out.format("%12s","Gender");
		System.out.format("%20s","Address_home");
		System.out.format("%15s","Cus_Type");
		System.out.println();
	}
	//Method Covert Date.SQL -> Date.Util
	private static String covertDateSQL(java.sql.Date d) {
        java.util.Date utilDate = new java.util.Date(d.getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(utilDate);      
	}

}
@FunctionalInterface
interface changeType{
	public String changeTypeDL(int num);
}
