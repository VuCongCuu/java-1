package Assignment2_Obj;

import java.util.Scanner;
import Assignment2_Variable.ValidateField;

public class Account {

	//-------------------
	//FIELD
	private String khachhangNum;
	private int accType;
	private int accStatus = 0;
	private long acc_amount;
	
	//-------------------
	//SETTER && GETTER
	public String getkhachhangNum() {
		return khachhangNum;
	}
	public void setkhachhangNum(String khachhangNum) {
		this.khachhangNum = khachhangNum;
	}
	public int getAccType() {
		return accType;
	}
	public void setAccType(int accType) {
		this.accType = accType;
	}
	public int getAccStatus() {
		return accStatus;
	}
	public void setAccStatus(int accStatus) {
		this.accStatus = accStatus;
	}
	public long getAcc_amount() {
		return acc_amount;
	}
	public void setAcc_amount(long acc_amount) {
		this.acc_amount = acc_amount;
	}

	//-------------------
	//METHOD
	public void addInfoAcc()
	{
		Scanner sav = new Scanner(System.in);
		try{
			//FIELD CUSTOMER ID
			while(true) {
				System.out.print("Enter Customer ID: ");
				this.khachhangNum = sav.nextLine();
				if(ValidateField.isValidCusNumber(this.khachhangNum )) {
					break;
				}else {
					System.out.println("Please Enter Customer Number Have 7 Characters And Not Null, Not Contain Space");
				}
			}
			//FIELD ACCOUNT TYPE
			while(true) {
				System.out.print("Enter Account Type(0:AccountPayFirst / 1:Account Visa ): ");
				this.accType = sav.nextInt();
				if(ValidateField.isValidCusType(this.accType)) {
					break;
				}else {
					System.out.println("Please Enter Follow By Instructor");
				}
			}
			//FIELD AMOUNT
			while(true) {
				System.out.print("Enter Amount Money: ");
				this.acc_amount = sav.nextLong();
				if(ValidateField.isValidAmount(this.acc_amount)) {
					break;
				}else {
					System.out.println("Please Enter Amount Money More Than 0");
				}
			}
			
		}catch(Exception e) {
			System.out.println("Error Add Info Account "+e.getMessage());
		}
	}	
}
