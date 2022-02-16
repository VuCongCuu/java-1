package Assignment2_Obj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Assignment2_Variable.Constrain;
import Assignment2_Variable.ValidateField;

public class Customer {

	//-------------------
	//FIELD
	private String Cus_Num;
	private String Cus_Name;
	private String Cus_Identity;
	private String PhoneNumber;
	private String Email;
	private Date Birthdate;
	private int Gender;
	private String Address;
	private int Cus_Type;
	
	//-------------------
	//CONSTRUCTOR
	public Customer(String cus_Num, String cus_Name, String cus_Identity, String phoneNumber, String email,
			Date birthdate, int gender, String address, int cus_Type) {
		super();
		Cus_Num = cus_Num;
		Cus_Name = cus_Name;
		Cus_Identity = cus_Identity;
		PhoneNumber = phoneNumber;
		Email = email;
		Birthdate = birthdate;
		Gender = gender;
		Address = address;
		Cus_Type = cus_Type;
	}
	public Customer() {
		
	}
	
	//-------------------
	//SETTER && GETTER
		
	public String getCus_Num() {
		return Cus_Num;
	}
	public void setCus_Num(String cus_Num) {
		Cus_Num = cus_Num;
	}
	public String getCus_Name() {
		return Cus_Name;
	}
	public void setCus_Name(String cus_Name) {
		Cus_Name = cus_Name;
	}
	public String getCus_Identity() {
		return Cus_Identity;
	}
	public void setCus_Identity(String cus_Identity) {
		Cus_Identity = cus_Identity;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getBirthdate() {
		SimpleDateFormat sformat = new SimpleDateFormat("dd/MM/yyyy");
		return sformat.format(Birthdate);
	}
	public void setBirthdate(Date birthdate) {
		Birthdate = birthdate;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getCus_Type() {
		return Cus_Type;
	}
	public void setCus_Type(int cus_Type) {
		Cus_Type = cus_Type;
	}
	
	//-------------------
	//METHOD
	public void addInfoCustomer() {
		Scanner scx = new Scanner(System.in);
		try{
			//Field Customer Number (7 Characters,Not Null, Not Contain Space)
			while(true) {
				System.out.print("Enter Customer Number: ");
				this.Cus_Num = scx.nextLine();
				if(ValidateField.isValidCusNumber(this.Cus_Num)) {
					break;
				}else {
					System.out.println("Please Enter Customer Number Have 7 Characters And Not Null, Not Contain Space");
				}
			}
			//Field Customer Name (At Least 6 Characters, Start With Character, Maximum 50 Characters, Not Null)
			while(true) {
				System.out.print("Enter Customer Name: ");
				this.Cus_Name = scx.nextLine();
				if(ValidateField.isValidUserName(Cus_Name)) {
					break;
				}else {
					System.out.println("Please Enter Name At Least 6 Characters, Start With Character, Maximum 50 Characters, Not Null");
				}
			}
			//Field Identity Have 6 Characters And This Must Be Digits
			while(true) {
				System.out.print("Enter Customer Identity: ");
				this.Cus_Identity = scx.nextLine();
				if(ValidateField.isValidIdentity(this.Cus_Identity)) {
					break;
				}else {
					System.out.println("Please Enter Customer Identity Have 6 Characters And This Must Be Digits");
				}
			}
			//Field Email Follow By Regular Expression
			while(true) {
				System.out.print("Enter Email: ");
				this.Email = scx.nextLine();
				if(ValidateField.isValidEmail(this.Email)) {
					break;
				}else {
					System.out.println("Please Enter Email Follow By Example: example@gmail.com");
				}
			}
			//Field PhoneNumber At Least 10 Digits
			while(true) {
				System.out.print("Enter PhoneNumber: ");
				this.PhoneNumber = scx.nextLine();
				if(ValidateField.isValidPhoneNum(this.PhoneNumber)) {
					break;
				}else {
					System.out.println("Please Enter Phone Number Have 10 Digists");
				}
			}
			//Field Birthday Follow By Format DD/MM/YYYY
			while(true) {
				System.out.print("Enter Birthdate: ");
				String s_date = scx.nextLine();
				if(ValidateField.isValidDateFormat(s_date)) {
					this.Birthdate = Constrain.dateFormated.parse(s_date);
					break;
				}else {
					System.out.println("Please Enter Birthdate Follow By Format dd/MM/yyyy");
				}
			}
			//Field Address
			while(true) {
				System.out.print("Enter Address: ");
				this.Address = scx.nextLine();
				if(this.Address == null || this.Address.length() < 5) {
					System.out.println("Please Enter Address And Address At 5 Characters");
				}else {
					break;
				}
			}
			//Field Gender
			while(true) {
				System.out.print("Enter Gender(1:Male / 0:Female / 2:Other): ");
				this.Gender = scx.nextInt();
				if(ValidateField.isValidGender(this.Gender)) {
					break;
				}else {
					System.out.println("Please Choose Follow By Instructor");
				}
			}
			//Field Customer Type
			while(true) {
				System.out.print("Enter Customer Type(0:Normal / 1:Vip): ");
				this.Cus_Type = scx.nextInt();
				if(ValidateField.isValidCusType(this.Cus_Type)) {
					break;
				}else {
					System.out.println("Please Choose Follow By Instructor");
				}
			}
		}catch(Exception e){
			System.out.println("Error Found Customer Add Info "+e.getMessage());
		}
	}
}
