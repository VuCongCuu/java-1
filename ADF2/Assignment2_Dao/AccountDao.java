package Assignment2_Dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Assignment2_Variable.Constrain;
import Assignment2_Variable.ValidateField;
import Assignment2_Obj.Account;
import Assignment2_Obj.TransactionAcc;
import Assignment2_Variable.DBconnection_Assignment2;

public class AccountDao {
	
	//SQL STATEMENT
	private static final String SQL_WITHDRAW_AMOUNT_VISA ="Exec withDrawVisa ?,?,?,?,?,?";
	private static final String SQL_WITHDRAW_AMOUNT_DEFAULT="Exec withDrawDefault ?,?,?,?,?,?";
	
	// Menu Account
	public static void menuAccount() {
		String confirm = "";
		Boolean flag = false;
		Scanner sc = new Scanner(System.in);
			do {
				try {
				System.out.println("----- MENU ACCOUNT -----");
				System.out.println("------------------------");
				System.out.println("1: CREATE NEW ACCOUNT");
				System.out.println("2: PAYIN MONEY INTO ACCOUNT");
				System.out.println("3: WITHDRAW MONEY FROM ACCOUNT");
				System.out.println("4: SHOW INFO ACCOUNT BY CUSTOMER NUMBER");
				System.out.println("5: SHOW INFO ACCOUNT BY ACCOUNT NUMBER");
				System.out.println("6: SHOW LIST ACCOUNT IN DB");
				System.out.println("7: ADD LIST ACCOUNT TO DB");
				System.out.println("8: EXTRACT LIST ACCOUT TO FILE");
				System.out.println("9: EXIT");
				System.out.print("ENTER CHOOSE: ");
				int choose = sc.nextInt();
				switch (choose) {
				case 1:
					addAccountCus();
					break;
				case 2:
					payinAccount();
					break;
				case 3:
					withdrawAccount();
					break;
				case 4:
					showAccountCus_Num();
					break;
				case 5:
					showAccountCus_Acc();
					break;
				case 6:
					showListAccount("");
					break;
				case 7:
					addListAcc();
					break;
				case 8:
					showListAccount("Extract");
					break;
				case 9:
					flag = true;
					break;
				default:
					System.out.println("PLEASE CHOOSE FOLLOW BY INSTRUCTOR");
					break;
				}
				if (!flag) {
					System.out.print("DO YOU WANT TO CONTINUE WORK WITH MENU ACCOUNT(n:EXIT): ");
					confirm = sc.nextLine();
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error Found Menu Account " + e.getMessage());
			}
				sc.nextLine();
			} while (!confirm.equalsIgnoreCase("n") && !flag);
	}

	// Method Create New Account By Customer Number -> Only Acc_Type = 0
	private static void addAccountCus() {
		// B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if (con == null) {
			System.out.println("Connection Error");
		}
		// B2:Create SQL
		String sql = "Exec createAccount ?,?,?,?,?,?";
		Account newAcc = new Account();
		newAcc.addInfoAcc();
		// Active account if Needed
		Scanner sot = new Scanner(System.in);
		try {
			System.out.print("Your Account Have Not Active! Do You Want To Active Now(1:Yes / 0:No): ");
			int choice = sot.nextInt();
			if (choice == 1) {newAcc.setAccStatus(1);System.out.println("Active Success");}
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, newAcc.getkhachhangNum());
			cs.setInt(2, newAcc.getAccType());
			cs.setInt(3, newAcc.getAccStatus());
			cs.setLong(4, newAcc.getAcc_amount());
			cs.registerOutParameter(5, Types.INTEGER);
			cs.registerOutParameter(6, Types.NVARCHAR);
			cs.executeUpdate();
			// B3:Result
			//int res_sign = cs.getInt(5);
			String res_mess = cs.getString(6);
			cs.close();		
			System.out.println(res_mess);
		} catch (Exception e) {
			System.out.println("Error Found Add Account " + e.getMessage());
		}
		// B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}

	// Method Pay In Amount By Customer Number -> If Acc_Type = 0
	private static void payinAccount() {
		// B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if (con == null) {System.out.println("Error Connection");}
		// B2:Create SQL
		String sql = "Exec addAmountToAcc ?,?,?,?";
		// Create A New Transaction
		TransactionAcc newTran = new TransactionAcc();
		newTran.addTransac();
		//Print Amount Money Inside Account
		System.out.println("Amount Money Of Account : "+newTran.getSoTK()+": "+getAmountAcc(newTran.getSoTK()));
		if(!checkActive(newTran.getSoTK())) {
			Scanner sx = new Scanner(System.in);
			System.out.println("Account: "+(newTran.getSoTK()+" Need To Active Before Transact"));
			System.out.print("Active Now!(y:Confirm): ");
			String confirm12 = sx.nextLine();
			if(confirm12.equalsIgnoreCase("y")) {activeAcc(newTran.getSoTK());
			}else {
				return;
			}
		};
		// Set Type Transaction
		newTran.setLoadGD(0);
		// Auto Add New Transaction To DB
		TransactionDao.createTransac(newTran);
		// Bind Parameter
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, newTran.getSoTK());
			cs.setLong(2, newTran.getAmountAdd());

			cs.registerOutParameter(3, Types.INTEGER);
			cs.registerOutParameter(4, Types.NVARCHAR);
			cs.executeUpdate();
//			int res_sign = cs.getInt(3);
			String res_mess = cs.getString(4);
			cs.close();
			// B3:Result
			System.out.println(res_mess);
		} catch (SQLException e) {
			System.out.println("Error Found Add Amount To Acc " + e.getMessage());
		}
		// B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}

	//-------------- Case 3
	// Method Withdraw Amount By Customer Number
	private static void withdrawAccount() {
		Scanner sx = new Scanner(System.in);
		String confirm = "";
		do {
			String accnum = null;
			// Get Account Number
			while (true) {
				System.out.print("Enter Account Number To WithDraw: ");
				accnum = sx.nextLine();
				if (ValidateField.isValidAccNumber(accnum)) {
					break;
				} else {
					System.out.println("Please Enter Account Number Have 9 Digits And Not Null");
				}
			}
			//Check Account Active
			if(!checkActive(accnum)) {
				System.out.println("Account: "+accnum+" Need To Active Before Transact");
				System.out.print("Active Now!(y:Confirm): ");
				String confirm12 = sx.nextLine();
				if(confirm12.equalsIgnoreCase("y")) {activeAcc(accnum);
				}else {
					return;
				}
			}
			// Check TK -> Return Account Type
			if (whatAccType(accnum) == Constrain.TYPE_ACCOUNT_VISA) {
				System.out.println(
						"Threshold Month Of Account: " + accnum + "  Remain Are: " + getAmountThreshold(accnum));
				withDrawAccount(accnum,SQL_WITHDRAW_AMOUNT_VISA);
			} else if (whatAccType(accnum) == Constrain.TYPE_ACCOUNT_DEFAULT) {
				System.out.println("Amount Money In Account: " + accnum + ": " + getAmountAcc(accnum));
				withDrawAccount(accnum,SQL_WITHDRAW_AMOUNT_DEFAULT);
			} else {
				System.out.println("This Account Number Don't Exist!");
			}
			// Control Withdraw With Another Account Number
			System.out.print("Do You Want To Continue WithDraw With Another Account Number(n:Exit): ");
			confirm = sx.nextLine();
		} while (!confirm.equalsIgnoreCase("n"));
	}

	//Account active
	private static boolean checkActive(String accum) {
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		//B2:Create SQL
		String sql = "Select Acc_Status from TaiKhoan Where Acc_Num = ?";
		int result = 0;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, accum);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {result = rs.getInt(1);}
			//B3:Result
			if(result == 1) {return true;}
		} catch (SQLException e) {
			System.out.println("Error Found Check Active "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
		return false;
	}
	
	private static void activeAcc(String accum) {
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null)System.out.println("Error Connection");
		//B2:Create SQL
		String sql = "Update TaiKhoan Set Acc_Status = 1 Where Acc_Num = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			//Bind Parameter
			ps.setString(1,accum);
			int run = ps.executeUpdate();
			//B3:Result
			if(run == 0)System.out.println("Active Account Have Error");
		} catch (SQLException e) {
			System.out.println("Error Found Active Account "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	// Get Account Type
 	private static int whatAccType(String accnum) {
		int typeaccont = -1;
		// B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if (con == null) {
			System.out.println("Error Connection");
		}
		// B2:Create SQL
		String sql = "Select Acc_Type From TaiKhoan Where Acc_Num = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// Bind Parameter
			ps.setString(1, accnum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				typeaccont = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Error Found Check Type Account " + e.getMessage());
		}
		// B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
		return typeaccont;
	}

	// WithDraw Account
	private static void withDrawAccount(String accnum,String sqlStatement) {
		Scanner sct = new Scanner(System.in);
		// B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if (con == null) {
			System.out.println("Error Connection");
		}
		// B2:Create SQL: Store Procedure Update Amount
		long amount_m = 0;
		while (true) {
			System.out.print("Enter Amount Money Want To WithDarw: ");
			amount_m = sct.nextLong();
			if (ValidateField.isValidAmount(amount_m)) {
				break;
			} else {
				System.out.println("Please Enter Amount Money More Than 0");
			}
		}
		try {
			CallableStatement cs = con.prepareCall(sqlStatement);
			cs.setString(1, accnum);
			cs.setLong(2, amount_m);
			cs.setString(3,Constrain.getRandomPlace());
			
			cs.registerOutParameter(4,Types.NUMERIC);
			cs.registerOutParameter(5, Types.INTEGER);
			cs.registerOutParameter(6, Types.NVARCHAR);
			cs.executeUpdate();
			long amo = cs.getLong(4);
			int sign = cs.getInt(5);
			String mes = cs.getString(6);
			cs.close();
			// B3:Result
			if(sign == 0) {
				System.out.println(mes);
			}else {
				System.out.println(mes);
				if(sqlStatement.equals(SQL_WITHDRAW_AMOUNT_DEFAULT)) {
					System.out.println("Amount Money In Account: "+amo);					
				}else {
					System.out.println("Threshold Month Of Account Remain are: "+amo);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error Found WithDrawDefault "+e.getMessage());
		}
		// B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}

	// Get Amount Money
	private static long getAmountAcc(String accnum) {
		long money = -1;
		// B1:Connection BD
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if (con == null) {
			System.out.println("Error Connection");
		}
		// B2:Create SQL
		String sql = "Select Sum(Acc_Amount) From TaiKhoan Where Acc_Num = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, accnum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				money = rs.getLong(1);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error Found Get Amount " + e.getMessage());
		}
		// B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
		return money;
	}

	// Get Amount Threshold In Visa Account
	private static long getAmountThreshold(String accum) {
		long money = -1;
		// B1:Connection BD
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if (con == null) {
			System.out.println("Connection Error");
		}
		// B2:Create SQL
		String sql = "Select Acc_threshold From TaiKhoan Where Acc_Num = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// Bind Parameter
			ps.setString(1, accum);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				money = rs.getLong(1);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			System.out.println("Error Found Get Amount Threshold " + e.getMessage());
		}
		DBconnection_Assignment2.getInstance().closeConnection(con);
		return money;
	}

	//-------------- Case 4
	// Method Show Info Account By Customer Number
	private static void showAccountCus_Num() {
		// B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if (con == null) {
			System.out.println("Error Connection");
		}
		// B2:Create SQL
		String sql = "Select Id,Cus_Num,Acc_Num,Acc_Type,Acc_Status,Acc_Created,Acc_Amount,Acc_threshold From TaiKhoan Where Cus_Num = ?";
		Scanner ste = new Scanner(System.in);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.print("Enter Customer Number: ");
			String cuscode = ste.nextLine();
			ps.setString(1, cuscode);
			// Convert Account Type & Account Status
			CovertAcc covertAccType = (int t) -> {
				if (t == Constrain.TYPE_ACCOUNT_DEFAULT) {
					return "PAYIN ACCOUNT";
				} else if (t == Constrain.TYPE_ACCOUNT_VISA) {
					return "VISA ACCOUNT";
				} else {
					return null;
				}
			};

			CovertAcc covertAccStatus = (int t) -> {
				if (t == 0) {
					return "Disable";
				} else if (t == 1) {
					return "Active";
				} else {
					return null;
				}
			};

			ResultSet rs = ps.executeQuery();
			boolean flag = true;
			while (rs.next()) {
				if (flag) {
					titleListAcc();
					flag = false;
				}
				System.out.format("%5d", rs.getInt(1));
				System.out.format("%20s", rs.getString(2));
				System.out.format("%20s", rs.getString(3));
				System.out.format("%20s", covertAccType.getName(rs.getInt(4)));
				System.out.format("%10s", covertAccStatus.getName(rs.getInt(5)));
				System.out.format("%20s", Constrain.dateFormated.format((rs.getDate(6))));
				System.out.format("%10d", rs.getLong(7));
				System.out.format("%15d", rs.getLong(8));
				System.out.println();
			}
			rs.close();
			ps.close();
			// B3:Result
			if (flag)
				System.out.println("Please Check Again Customer Number!");

		} catch (SQLException e) {
			System.out.println("Error Found Show Account By Customer Number" + e.getMessage());
		}
		// B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}

	// Method Show Info Account By Acc_Num
	
	//-------------- Case 5
	//Method Show Customer Account
	private static void showAccountCus_Acc() {
		// B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if (con == null) {
			System.out.println("Error Connection");
		}
		// B2:Create SQL
		String sql = "Select Id,Cus_Num,Acc_Num,Acc_Type,Acc_Status,Acc_Created,Acc_Amount,Acc_threshold From TaiKhoan Where Acc_Num = ?";
		Scanner ste = new Scanner(System.in);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// Get Parameter
			System.out.print("Enter Account Number: ");
			String cuscode = ste.nextLine();
			// Bind Parameter
			ps.setString(1, cuscode);
			// Lambda Expression To Convert Account Type & Account Status
			CovertAcc covertAccType = (int t) -> {
				if (t == 0) {
					return "PAYIN ACCOUNT";
				} else if (t == 1) {
					return "VISA ACCOUNT";
				} else {
					return null;
				}
			};

			CovertAcc covertAccStatus = (int t) -> {
				if (t == 0) {
					return "Disable";
				} else if (t == 1) {
					return "Active";
				} else {
					return null;
				}
			};
			// Get ResultSet Of SQL
			ResultSet rs = ps.executeQuery();
			boolean flag = true;
			while (rs.next()) {
				if (flag) {
					titleListAcc();
					flag = false;
				}
				System.out.format("%5d", rs.getInt(1));
				System.out.format("%20s", rs.getString(2));
				System.out.format("%20s", rs.getString(3));
				System.out.format("%20s", covertAccType.getName(rs.getInt(4)));
				System.out.format("%10s", covertAccStatus.getName(rs.getInt(5)));
				System.out.format("%20s", Constrain.dateFormated.format((rs.getDate(6))));
				System.out.format("%14d", rs.getLong(7));
				System.out.format("%14d", rs.getLong(8));
				System.out.println();
			}
			rs.close();
			ps.close();
			// B3:Result
			if (flag)
				System.out.println("Please Check Again Account Number!");
		} catch (SQLException e) {
			System.out.println("Error Found Show Account By Account Number" + e.getMessage());
		}
		// B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}

	//-------------- Case 6
	private static void showListAccount(String type) {
		//B1:Connection BD
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		//B2:Create SQL
		String sql = "Select Id,Cus_Num,Acc_Num,Acc_Type,Acc_Status,Acc_Created,Acc_Amount,Acc_threshold From TaiKhoan";
		boolean flag = true;
		CovertAcc covertAccType = (int t) -> {
			if (t == 0) {
				return "PAYIN ACCOUNT";
			} else if (t == 1) {
				return "VISA ACCOUNT";
			} else {
				return null;
			}
		};

		CovertAcc covertAccStatus = (int t) -> {
			if (t == 0) {
				return "Disable";
			} else if (t == 1) {
				return "Active";
			} else {
				return null;
			}
		};
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			boolean inFile = true;
			String nameFile = null;
			while(rs.next()) {
				//Control Show List Account 
				if(type == "") {
					if(flag) {flag = false;titleListAcc();};
					System.out.format("%5d", rs.getInt(1));
					System.out.format("%20s", rs.getString(2));
					System.out.format("%20s", rs.getString(3));
					System.out.format("%20s", covertAccType.getName(rs.getInt(4)));
					System.out.format("%10s", covertAccStatus.getName(rs.getInt(5)));
					System.out.format("%20s", Constrain.dateFormated.format((rs.getDate(6))));
					System.out.format("%14d", rs.getLong(7));
					System.out.format("%14d", rs.getLong(8));
					System.out.println();					
				}
				String line =String.valueOf(rs.getInt(1))+" , "+rs.getString(2)+" , "+rs.getString(3)+" , "+covertAccType.getName(rs.getInt(4))
				+" , "+covertAccStatus.getName(rs.getInt(5))+" , "+Constrain.dateFormated.format((rs.getDate(6)))+" , "
						+String.valueOf(rs.getLong(7))+" , "+String.valueOf(rs.getLong(8))+"\n";
				//Control Menu Extract List Account
				if(type.equalsIgnoreCase(Constrain.EXTRACT_FILE_WORD) && inFile) {
					//File Only Create 1 Times
					inFile = false;flag = false;
					//Create File
					nameFile = createFile();
				}
				//WriteFile Text ->How Many Record -> How Many Time This Function Run
				if(!inFile) {writeFile(nameFile,line);}
			}
			//B3:Result
			if(flag)System.out.println("Data Is Loading");
			if(!inFile)System.out.println("Extract File Successfully");
			ps.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error Found Show List Account "+e.getMessage());
		} 
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	private static void writeFile(String pathname ,String line) {
		try(FileOutputStream fos = new FileOutputStream(pathname,true);){
			byte[] b = line.getBytes();
			fos.write(b);
			fos.flush();
		}catch(IOException e) {
			System.out.println("Error Found Write File "+e.getMessage());
		}
	}
	
	private static String createFile() {
		Scanner sc = new Scanner(System.in);
		String name = null;
		boolean flag = false;
		while(true) {
			//Get Name File 
			System.out.print("Enter File Name(Include Extentsion Name): ");
			String name1 = sc.nextLine();
			//Absolute Path To Store File
			File store = new File(Constrain.URL_FILE_READY_READ);
			//Check Folder Is Directory
			if(store.isDirectory()) {
				File[] dsFiles = store.listFiles();
				for(File fl : dsFiles) {
					if(fl.getName().equalsIgnoreCase(name1)) {
						//If File Name Is Existed -> Show Notify To Continue Extract
						flag = true;
						System.out.println("File Is Already Exist");
						System.out.print("Do You Want To Continue To Extract To This File(n:Exist): ");
						String confirm = sc.nextLine();
						//Press n to Stop -> Enter File Name Again 
						if(!confirm.equalsIgnoreCase("n")) {
							break;
						}else {
							//Accept Extract File Exist -> Return Pathname
							name = fl.getAbsolutePath();
							return name;
						}
					}
				}
				//If The Name Is Not Exist -> Create New File -> Return Pathname
				if(!flag) {
					Path pat = Paths.get(Constrain.URL_FILE_READY_READ+"\\"+name1);
					try {
						Path p = Files.createFile(pat);
						return  name = p.toAbsolutePath().toString();
					} catch (IOException e) {
						System.out.println("Error Found Create File "+e.getMessage());
					}
				}
			}
			
		}
	}
	
	private static void titleListAcc() {
		System.out.format("%5s", "Id");
		System.out.format("%20s", "Cus_Num");
		System.out.format("%20s", "Acc_Num");
		System.out.format("%15s", "Acc_Type");
		System.out.format("%15s", "Acc_Status");
		System.out.format("%20s", "Acc_Created");
		System.out.format("%15s", "Acc_Amount");
		System.out.format("%15s", "Acc_threshold");
		System.out.println();
	}
	
	//-------------- Case 7
	private static void addListAcc() throws SQLException {
		Scanner sc = new Scanner(System.in);
		//Print List File Exist
		CustomerDao.listFileReady();
		//Get FileName
		System.out.print("Enter File Name To Add: ");
		String name = sc.nextLine();
		//Check File Name
		boolean flag = false;
		File filestore = new File(Constrain.URL_FILE_READY_READ);
		if(filestore.isDirectory()) {
			File[] dsFiles = filestore.listFiles();
			for(File fl : dsFiles) {
				if(fl.getName().equalsIgnoreCase(name)) {
					flag = true;
					addListDB(listaccount(fl.getAbsolutePath()));
					break;
				}
			}
		}
		if(!flag)System.out.println("File Name Is Not Match Any File In Folder");
	}
	
	//Method Return List Account
	private static List<String> listaccount(String filepathname){
		List<String> list = new ArrayList<String>();
		List<String> listkq = new ArrayList<String>();
		try {
			list = Files.readAllLines(Paths.get(filepathname));
			for(String str : list) {		
					try {
						ValidateFieldAcc(str);
						listkq.add(str);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
			}
		} catch (IOException e) {
			System.out.println("Error Found ReadFile "+e.getMessage());
		}
		for(String str : listkq) {
			System.out.println(str);
		}
		return listkq;
	}
	//Add List Account To DB 
	private static void addListDB(List<String> list) throws SQLException {
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null) {
			System.out.println("Error Connection");
		}
		con.setAutoCommit(false);
		boolean flag =false;
		//B2:Create SQL
		String sql ="Insert Into TaiKhoan(Cus_Num,Acc_Num,Acc_Type,Acc_Status,Acc_Created,Acc_Amount,Acc_threshold) Values(?,?,?,?,Convert(date,?,103),?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for(String acc : list) {
				flag = true;
				String[] arrLine = acc.split(",");
				ps.setString(1, arrLine[0]);
				ps.setString(2,arrLine[1]);
				ps.setInt(3,Integer.parseInt(arrLine[2]));
				ps.setInt(4,Integer.parseInt(arrLine[3]));
				ps.setString(5,arrLine[4]);
				ps.setLong(6, Long.parseLong(arrLine[5]) );
				ps.setLong(7,Long.parseLong(arrLine[6]));
				ps.addBatch();
			}
			//B3:Result
			int[] runs = ps.executeBatch();
			if(flag)System.out.println("Add Successfully");
			ps.close();
			con.commit();
			con.rollback();
		} catch (SQLException e) {
			System.out.println("Error Found Add List Acc "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	
	//Method Validate Field Account
	private static void ValidateFieldAcc(String line) throws Exception {
		if(line == null) {
			throw new Exception("Input Is Empty");
		}
		String[] arrLine = line.split(",");
		if(arrLine.length != 7) {
			throw new Exception("Input Is Not Enough Field");
		}else {
			if(!ValidateField.isValidCusNumber(arrLine[0])) {
				throw new Exception("Customer Number Must Be 7 Charaters");
			}
			if(!ValidateField.isValidAccNumber(arrLine[1])) {
				throw new Exception("Account Number Must Be Digits And Have 9 Digits");
			}
			if(!ValidateField.isValidCusType(Integer.parseInt(arrLine[2]))) {
				throw new Exception("Account Type Must Be 0:PayIn Account / 1:Visa Account");
			}
			if(!ValidateField.isValidCusType(Integer.parseInt(arrLine[3]))) {
				throw new Exception("Account Statuss Must Be 0:Disable / 1:Active");
			}
			if(!ValidateField.isValidDateFormat(arrLine[4])) {
				throw new Exception("Date Created Must Be Follow By dd/MM/yyyy");
			}
			if(!ValidateField.isValidAmount(Long.parseLong(arrLine[5]))) {
				throw new Exception("Amount Must Be Digits And Not Less Than 0");
			}
			if(!ValidateField.isValidAmount(Long.parseLong(arrLine[6]))) {
				throw new Exception("Threshold Must Be Digits And Not Less Than 0");
			}
		}
	}
}
@FunctionalInterface
interface CovertAcc{
	public String getName(int num);
}
