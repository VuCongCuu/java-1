package Assignment2_Obj;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Assignment2_Variable.Constrain;
import Assignment2_Variable.ValidateField;

public class TransactionAcc {

	//--------------------
	//Field
	private String SoTK;
	private long amountAdd;
	private Date ngayTao;
	private int  loadGD;
	private String place;
	
	//--------------------
	//Constructor
	public TransactionAcc() {
		super();
	}
	

	//--------------------
	//Setter & Getter
	public String getSoTK() {
		return SoTK;
	}
	public void setSoTK(String soTK) {
		SoTK = soTK;
	}
	public long getAmountAdd() {
		return amountAdd;
	}
	public void setAmountAdd(long amountAdd) {
		this.amountAdd = amountAdd;
	}
	public String getNgayTao() {
		SimpleDateFormat formateDate = new SimpleDateFormat("dd/MM/yyyy");
		return formateDate.format(ngayTao);
	}
	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}
	public int getLoadGD() {
		return loadGD;
	}
	public void setLoadGD(int loadGD) {
		this.loadGD = loadGD;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	//--------------------
	//Method
	public void addTransac() {
		Scanner skk = new Scanner(System.in);
		try{
			//Field Account Number
			while(true) {
				System.out.print("Enter Account Number: ");
				this.SoTK = skk.nextLine();
				if(ValidateField.isValidAccNumber(this.SoTK)) {
					break;
				}else {
					System.out.println("Please Enter Account Number Have 9 Digist & Not Null");
				}
			}
			//Field Amount Add
			while(true) {
				System.out.print("Enter Amount Money Add: ");
				this.amountAdd = skk.nextLong();
				if(ValidateField.isValidAmount(this.amountAdd)) {
					break;
				}else {
					System.out.println("Please Enter Amount Money More Than 0");
				}
			}
			//Field Create Date
			this.ngayTao = new Date();
			//Field Place Create
			this.place = Constrain.getRandomPlace();
		}catch(Exception e) {
			System.out.println("Error Found Create Transaction "+e.getMessage());
		}
	}
}
