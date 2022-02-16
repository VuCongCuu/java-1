package Assignment2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Assignment2_Dao.AccountDao;
import Assignment2_Dao.CustomerDao;
import Assignment2_Dao.TransactionDao;
import Assignment2_Variable.DBconnection_Assignment2;

public class BankManager_Main {
	public static void main(String[] args) {
		//Thread Main Menu
		main_menu();
		//------> Thread Update Threshold In Day Of Each Account
		Runnable runUpdateThresh = new UpdateThreshold();
		Thread updateThread = new Thread(runUpdateThresh);
		updateThread.start();
		
		//------> Thread Update Account Visa In Month
		// 5  -> Send Notify Total Amount Spend In Previous Month
		// 10 -> Subtract Total Amount Spend In Previous Month -> Update Amount Of 1 Visa Account
		Runnable runPay = new VisaPayInMonth();
		Thread notifyAccount = new Thread(runPay) ;
		notifyAccount.start();
	}
	
	public static void main_menu() {
		String confirm = "";
		Boolean flag = false;
		Scanner scf = new Scanner(System.in);
		do {
			try {
				System.out.println("===== BANK MANAGER =====");
				System.out.println("------------------------");
				System.out.println("1: CRUD WITH CUSTOMER");
				System.out.println("2: CRUD WITH ACCOUNT");
				System.out.println("3: REPORT");
				System.out.println("4: Exit");
				System.out.print("ENTER CHOOSE: ");
				int choose = scf.nextInt();
				switch (choose) {
				case 1:
					CustomerDao.menuCustomer();
					break;
				case 2:
					AccountDao.menuAccount();
					break;
				case 3:
					TransactionDao.menuTransaction();
					break;
				case 4:
					System.out.println("THANKS!");
					flag = true;
					break;
				default:
					System.out.println("PLEASE ENTER FOLLOW BY INSTRUCTOR");
					break;
				}
				if (!flag) {
					System.out.print("DO YOU WANT TO CONTINUE WORK WITH PROGRAM(n:EXIT): ");
					confirm = scf.nextLine();
				}
			} catch (Exception e) {
				System.out.println("Error Found " + e.getMessage());
			}
			scf.nextLine();
		} while (!confirm.equalsIgnoreCase("n") && !flag);

	}

}
//
class UpdateThreshold implements Runnable{//12h updat thre
	private void updateThresh() {
		//B1:Connect DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null)System.out.println("Error Connection");
		//B2:Create SQL
		String sql = "Exec updateThreshold";
		try {
			CallableStatement cs = con.prepareCall(sql);
			int run = cs.executeUpdate();
			//B3:Result
			if(run ==0)System.out.println("Error Execute Update Threshold");
			cs.close();
		} catch (SQLException e) {
			System.out.println("Error Found Update Thresh "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("");
		}
		updateThresh();
	}
	
}
//
class VisaPayInMonth implements Runnable{//
	
	private void NotifyAccount(String accnum) {
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null)System.out.println("Error Connection");
		//B2:Create SQL 
		String sql = "Exec notifyPay ?,?,?";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, accnum);
			cs.registerOutParameter(2, Types.NVARCHAR);
			cs.registerOutParameter(3,Types.INTEGER);
			cs.executeUpdate();
			int sign = cs.getInt(3);
			String mess = cs.getString(2);
			if(sign == 0) {
				System.out.println(mess);				
			}else {
				System.out.println(mess);
			}
		} catch (SQLException e) {
			System.out.println("Error Found Notify "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	private void listAccTran() {
		List<String> listAccNum = new ArrayList<String>();
		//B1:Connection DB
		Connection con = DBconnection_Assignment2.getInstance().getConnection();
		if(con == null)System.out.println("Error Connection");
		//B2:Create SQL
		String sql ="Exec TransListPreMonth";
		try {
			CallableStatement cs = con.prepareCall(sql);
			ResultSet rs = cs.executeQuery();
			boolean flag = false;
			//Result Return A Table Consist A List Distinct Account Number
			while (rs.next()) {
				flag = true;
				listAccNum.add(rs.getString(1));
			}
			//Execute VisaPay For Every Visa Account Has Transaction In Previous Month
			if(flag) {
				for(String str : listAccNum) {
					NotifyAccount(str);
				}				
			}else {
				System.out.println("No Date Update");
			}
			cs.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Error Found Get List Tran "+e.getMessage());
		}
		//B4:Close Connection
		DBconnection_Assignment2.getInstance().closeConnection(con);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println();
		}
		listAccTran();
	}
	
} 
