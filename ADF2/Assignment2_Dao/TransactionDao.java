package Assignment2_Dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
import java.util.List;
import java.util.Scanner;

import Assignment2_Variable.ValidateField;
import Assignment2_Obj.TransactionAcc;
import Assignment2_Variable.Constrain;
import Assignment2_Variable.DBconnection_Assignment2;

public class TransactionDao {
	private static List<String> listCusNumber = new ArrayList<String>();
	private static final int TYPE_CUSTOMER_SHOW_TRANSACTION = 1;
	private static final int TYPE_EXTRACT_FILE = 0;
	
	//Menu Transaction
	public static void menuTransaction() {
		String confirm = "";
		Boolean flag = false;
		Scanner sca = new Scanner(System.in);
				do {
					try {
				System.out.println("----- MENU REPORT -----");
				System.out.println("-----------------------");
				System.out.println("1: SHOW LIST TRAN OF 1 ACCOUNT");
				System.out.println("2: SHOW LIST TRAN OF 1 CUSTOMER");
				System.out.println("3: EXTRACT FILE LIST TRANS OF EACH CUSTOMER BY MONTH(MM/yyyy)");
				System.out.println("4: TOP 5 ACCOUNT HAVE THE MOST TRANSACTION BY MONTH(MM/yyyy)");
				System.out.println("5: SHOW A NUMBER OF TRANSACTIONS ARE TRANSACTED BY ONE ACCOUNT IN 3 MONTH NEARLY");
				System.out.println("6: EXIT");
				System.out.print("ENTER CHOOSE: ");
				int choose = sca.nextInt();
				switch(choose) {
				case 1:
					showAcc_Tran();
					break;
				case 2:
					showCus_Tran();
					break;
				case 3:
					extractFileTran();
					break;
				case 4:
					get5AccTran();
					break;
				case 5:
					showTranAccThreeMonth();
					break;
				case 6:
					flag = true;
					break;
				default:
					System.out.println("PLEASE CHOOSE FOLLOW BY INSTRUCTOR");
					break;
				}
				if(!flag) {
					System.out.print("DO YOU WANT TO COUNTINUE WORK WITH MENU REPORT(n:EXIT): ");
					confirm = sca.nextLine();
				}
					}catch(Exception e){
						System.out.println("Error Found Menu Report "+e.getMessage());
					}
				sca.nextLine();
			}while(!confirm.equalsIgnoreCase("n") && !flag);
	}
	
	public static void createTransac(TransactionAcc tran) {
		//B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		//B2:Create SQL
		String sql = "Insert Into GiaoDich(Acc_Num,Type_Tran,Amount,Tran_Created,Tran_Place) Values(?,?,?,Convert(date,?,103),?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//Bind Parameter
			ps.setString(1,tran.getSoTK());
			ps.setInt(2,tran.getLoadGD());
			ps.setLong(3,tran.getAmountAdd());
			ps.setString(4,tran.getNgayTao());
			ps.setString(5,tran.getPlace());
			int run = ps.executeUpdate();
			ps.close();
			//B3:Result;
			if(run == 0) System.out.println("Insert Into GiaoDich Have Error");
		} catch (SQLException e) {
			System.out.println("Error Found Add Transaction "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	//Method Show Info Transaction Of 1 Account
	private static void showAcc_Tran() {
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Connection Error");
		}
		//B2:Create SQL
		String sql = "Exec show1AccountTran ?,?,?";
		try{
			CallableStatement cs = con.prepareCall(sql);
			AccTranObj newCusFind = new AccTranObj();
			newCusFind.addTT();
			cs.setString(1, newCusFind.getAccNumber());
			cs.setString(2, newCusFind.getDateStart());
			cs.setString(3, newCusFind.getDateEnd());
			ResultSet result = cs.executeQuery();
			boolean flag = true;
			while(result.next()) {
				if(flag) {
					System.out.println("     List Transactions Of Account Number "+newCusFind.getAccNumber()+ "  Between "+newCusFind.getDateStart()+" And "+newCusFind.getDateEnd());
					System.out.println();
					TilteCus1();
					flag = false;
				}
				String datess = Constrain.dateFormated.format(result.getDate(4));
				System.out.format("%5d",result.getInt(1));
				System.out.format("%20s",String.valueOf(result.getLong(2)));
				System.out.format("%15d",result.getInt(3));
				System.out.format("%15s",datess);
				System.out.format("%20s",result.getString(5));
				System.out.println();
			}
			cs.close();
			//B3:Result
			if(flag) {
				System.out.println("This Month' Data Have Been Updated Or The Account Number Have No Transaction In This Month");
			}	
		} catch (Exception e) {
			System.out.println("Error Found Show Account Transaction "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	//Method Show List Transaction Of 1 Customer -> Follow By Date Input (Arrange Date && Type Transaction)
	private static void showCus_Tran() {
		Scanner syt = new Scanner(System.in);
			String cuscode;
			while(true) {
				System.out.print("Enter Customer Number: ");
				cuscode = syt.nextLine();
				if(ValidateField.isValidCusNumber(cuscode)) {
					break;
				}else {
					System.out.println("Please Enter Customer Number Have 7 Characters And Not Null, Not Contain Space");
				}
			}
			String month;
			while(true) {
				System.out.print("Enter Month/Year Need Find: ");
				month = syt.nextLine();
				if(ValidateField.isValidMonthFormat(month)) {
					break;
				}else {
					System.out.println("Please Enter Month Follow By Format MM/yyyy");
				}
			}
			//
			getRecordByCus(cuscode,month,TYPE_CUSTOMER_SHOW_TRANSACTION);
	}
	
	//Method Extract List Transaction Of 1 Customer Follow By Date(MM/YYYY) 
	private static void extractFileTran() {
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Connection Error");
		}
		//B2:Create SQL: Get All Customers Transaction In This Month
		String sql = "Exec getcustomercode ?";
		Scanner cuy =new Scanner(System.in);
		try{
			//Get Parameter
			String month;
			while(true) {
				System.out.print("Enter Month/Year Need Find: ");
				month = cuy.nextLine();
				if(ValidateField.isValidMonthFormat(month)) {
					break;
				}else {
					System.out.println("Please Enter Month Follow By Format MM/yyyy");
				}
			}
			CallableStatement cs = con.prepareCall(sql);
			//Bind Parameter
			cs.setString(1,month);
			boolean flag = false;
			ResultSet rs = cs.executeQuery();//
			while(rs.next()) {
				flag = true;
				listCusNumber.add(rs.getString(1));
			}
			cs.close();
			rs.close();
			//B3:Result
			if(!flag) {
				System.out.println("This month's data has not been updated");
			}else {
				for(String str: listCusNumber) {
					getRecordByCus(str,month,TYPE_EXTRACT_FILE);
				}
				//-> Notify Success
					System.out.println("Extract File Successful");	
			}
			//Clear List Customer
			listCusNumber.clear();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error Found Extract File "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}	
	
	//Method Get List Transaction In 3 Month Of 1 Account Number -> Not Yet
	private static void showTranAccThreeMonth() {
		Scanner sc = new Scanner(System.in);
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null)System.out.println("Error Connection");
		//B2:Create SQL
		String sql = "Select Acc_Num,Type_Tran,Amount,Tran_Created,Tran_Place Where Acc_Num = ? Order By Tran_Created";
		String accnum = null;
		while(true) {
			System.out.print("Enter Account Number:" );
			accnum = sc.nextLine();
			if(ValidateField.isValidAccNumber(accnum)) {
				break;
			}else {
				System.out.println("Please Enter Account Number Have 9 Digits");
			}
		}
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, accnum);
			int numberRecord = 0;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				numberRecord++;
				System.out.format("%");
				System.out.format("%");
				System.out.format("%");
				System.out.format("%");
				System.out.format("%");
				System.out.println();
			}
			//B3:Result
			if(numberRecord == 0) {
				System.out.println("No Data Update");								
			}else {
				System.out.println("Total Amount Transaction Of: "+accnum+" Is"+numberRecord);								
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error Found ");
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	//Method Get InFo Of Top 5 Account Have The Most Transaction By Month -> Not Yet
	private static void get5AccTran() {
		Scanner sc= new Scanner(System.in);
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null)System.out.println("Error Connection");
		//B2:Create SQL -> Return Result Set
		String sql ="Exec Top5MostTranInMonth ?,?";
		String namacc = null;String monthfind  = null;
		while(true) {
			System.out.print("Enter Account Number: ");
			namacc = sc.nextLine();
			if(ValidateField.isValidAccNumber(namacc)) {
				break;
			}else {
				System.out.println("Please Enter Account Number Have 9 Digits");
			}
		}
		while(true) {
			System.out.print("Enter Month To Watch: ");
			monthfind = sc.nextLine();
			if(ValidateField.isValidMonthFormat(monthfind)) {
				break;
			}else {
				System.out.println("Please Enter Month Follow By Format MM/yyyy");
			}
		}
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, namacc);
			ps.setString(2,monthfind);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.format("");
				System.out.format("");
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error Found Top 5 Acccount "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	//Method Get Each Customer Transaction
	public static void getRecordByCus(String custmcode,String month,int Type) {
		SimpleDateFormat newdatefor = new SimpleDateFormat("ddMMyyyy");
		//B1:Connection DB
			Connection con = DBconnection_Assignment2.getInstance().getConnection();
			if(con == null) {
			System.out.println("Connection Error");
			}
		//B2:Create SQL
				String sql ="Exec cusTranMonth ?,?";
				try {
					CallableStatement cs = con.prepareCall(sql);
					cs.setString(1, custmcode);
					cs.setString(2,month);
					boolean flag = false;
					boolean show1time = true;
					ResultSet rs = cs.executeQuery();
					if(Type == 0) {
						while(rs.next()) {
							flag = true;
							String dates = newdatefor.format(rs.getDate(5));
							String line = String.valueOf(rs.getInt(1))+" , "+rs.getString(2)+" , "+String.valueOf(rs.getInt(3))+" , "+String.valueOf(rs.getLong(4))+" , "+dates+" , "+rs.getString(6)+" , "+String.valueOf(rs.getInt(7));
							writeFile(line,custmcode);			
						}	
					}else {//show
						while(rs.next()) {
							flag = true;
							if(show1time) {
								System.out.println("        List Transaction Of Customer Number "+custmcode+" In "+month);
								System.out.println();
								TilteCus();
								show1time = false;
							}
							String datess = Constrain.dateFormated.format(rs.getDate(5));
							System.out.format("%5d",rs.getInt(1));
							System.out.format("%20s",rs.getString(2));
							System.out.format("%15d",rs.getInt(3));
							System.out.format("%20s",String.valueOf(rs.getLong(4)));
							System.out.format("%15s",datess);
							System.out.format("%20s",rs.getString(6));
							System.out.println();
						}
					}
					cs.close();
					rs.close();
					//B3:Result
					if(!flag) {
						System.out.println("The Month' Date Have Been Updated");
					}
				} catch (SQLException e) {
					System.out.println("Error Found Read Each Customer "+e.getMessage());
				}	
			//B4:Close Connection
			DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	//Method Write File
	public static void writeFile(String line,String mkh) {
		String[] arrLine = line.split(" , ");
		//Choose Folder And File To Append
		int type = Integer.parseInt(arrLine[6]);
		//Create Name
		String nameFile = mkh+"_"+arrLine[1]+"_"+arrLine[4]+".txt";
		//Remove Type Account ->
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < arrLine.length-1; i++) {
			if(i == arrLine.length-2) {
				sb.append(arrLine[i]);
			}else {
				sb.append(arrLine[i]+" , ");			
			}
	      }
	      String newLine = sb.toString()+"\n";
	      //Normal Account	
	      if(type == 0) {	
			writeRecordFile writeDefault = (String nam,String context,String fol)->{
				File filetext = new File(fol+"\\"+nam);
				try(
						FileOutputStream wr = new FileOutputStream(filetext,true);
						) {
					if(filetext.createNewFile()) {
						byte b[]=context.getBytes();
						wr.write(b);
						wr.flush();
					}else {
						byte b[]=context.getBytes();
						wr.write(b);
						wr.flush();
					}				
				} catch (IOException e) {
					System.out.println("Error Write File "+e.getMessage());
				}
			};
			writeDefault.startWriteFile(nameFile, newLine,Constrain.URL_EXTRACT_FILE_DEFAUL);
		}
		//Visa Account
		else {
			writeRecordFile writeDefault = (String nam,String context,String fol)->{
				File filetext = new File(fol+"\\"+nam);
				try(
						FileOutputStream wr = new FileOutputStream(filetext,true);
						) {
					if(filetext.createNewFile()) {
						byte b[]=context.getBytes();
						wr.write(b);
						wr.flush();
					}else {
						byte b[]=context.getBytes();
						wr.write(b);
						wr.flush();
					}				
				} catch (IOException e) {
					System.out.println("Error Write File "+e.getMessage());
				}
			};
			writeDefault.startWriteFile(nameFile, newLine,Constrain.URL_EXTRACT_FILE_VISA);
		}
	}
	
	
	
	
	
	//Write Title
	public static void TilteCus() {
		System.out.format("%5s","ID");
		System.out.format("%20s","ACCOUNT NUMBER");
		System.out.format("%25s","TYPE TRANSACTION");
		System.out.format("%10s","AMOUNT");
		System.out.format("%20s","TRANSACTION DATE");
		System.out.format("%20s","TRANSACTION PLACE");
		System.out.println();
	}
	public static void TilteCus1() {
		System.out.format("%5s","ID");
		System.out.format("%25s","TYPE TRANSACTION");
		System.out.format("%10s","AMOUNT");
		System.out.format("%20s","TRANSACTION DATE");
		System.out.format("%20s","TRANSACTION PLACE");
		System.out.println();
	}
}


@FunctionalInterface
interface writeRecordFile{
	public void startWriteFile(String name,String line,String folder);
}
class AccTranObj{
	//Field 
	private String accNumber;
	private Date dateStart;
	private Date dateEnd;
	
	//Setter && Getter
	public String getAccNumber() {
		return accNumber;
	}


	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}


	public String getDateStart() {
		return Constrain.dateFormated.format(dateStart);
	}


	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}


	public String getDateEnd() {
		return Constrain.dateFormated.format(dateEnd);
	}


	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	//Method Add Info
	public void addTT() throws ParseException {
		Scanner slo = new Scanner(System.in);
		try{
			while(true) {
				System.out.print("Enter Account Number: ");
				this.accNumber = slo.nextLine();
				if(ValidateField.isValidAccNumber(this.accNumber)) {
					break;
				}else{
					System.out.println("Please Enter Account Number Have 9 Digits And Not Null");
				}
			}
			while(true) {
				System.out.print("Enter Start Date: ");
				String datest = slo.nextLine();
				if(ValidateField.isValidDateFormat(datest)) {
					this.dateStart = Constrain.dateFormated.parse(datest);
					break;
				}else {
					System.out.println("Please Enter Date Follow By Format dd/MM/yyyy");
				}
			}
			while(true) {
				System.out.print("Enter End Date: ");		
				String dateed = slo.nextLine();	
				if(ValidateField.isValidDateFormat(dateed)) {
					this.dateEnd = Constrain.dateFormated.parse(dateed);
					break;
				}else {
					System.out.println("Please Enter Date Follow By Format dd/MM/yyyy");
				}
			}
		}catch(Exception e) {
			System.out.println("Error Found Add Info "+e.getMessage());
		}
	}
}
