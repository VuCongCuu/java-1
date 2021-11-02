package baiThi3.bai1;

import java.util.Scanner;

public class calculateInterest {
	 private double banlace;
	 private double rate;
	 private double tienLai;
	 

	    public calculateInterest(double banlace, double rate) {
	        this.banlace = banlace;
	        this.rate = rate;
	    }

	    public calculateInterest() {
	    }

	    public double getBanlace() {
	        return banlace;
	    }

	    public void setBanlace(double banlace) {
	        this.banlace = banlace;
	    }

	    public double getRate() {
	        return rate;
	    }

	    public void setRate(double rate) {
	        this.rate = rate;
	    }
	    public void nhapTT(){
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Nhap So Vay");
	        this.banlace = sc.nextDouble();
	        System.out.println("nhập lai xuat");
	        this.rate = sc.nextDouble();
	        tienLai = this.banlace*(this.rate/1200);
	    }
	    public void calculateInterest(){
	         tienLai = this.banlace*(this.rate/1200);
	        System.out.println("So tien vay: "+this.banlace +" "
					        		+",Lai xuat:" + this.rate +" "
					        		+ ",Tien Lai: "+tienLai);
	    }
	   
	    

		@Override
		public String toString() {
			return "calculateInterest [banlace=" + banlace + ", rate=" + rate + ", tienLai=" + this.tienLai + "]";
		}

		public void xuat(){
	        System.out.println(toString());
	    }
	    public static void main(String[] args){
	        calculateInterest back = new calculateInterest(1000,10);
	        back.calculateInterest();
	        calculateInterest bank2=new calculateInterest();
	        bank2.nhapTT();
	        System.out.println(bank2);
	        

	    }
}
