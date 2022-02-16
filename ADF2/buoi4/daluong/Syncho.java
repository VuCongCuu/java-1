package buoi4.daluong;

public class Syncho {
public static void main(String[] args) {
	Account myAC= new Account(10000);
	WithdrawThread t1 = new WithdrawThread(myAC, "T1");
	WithdrawThread t2 = new WithdrawThread(myAC, "T2");
	WithdrawThread t3 = new WithdrawThread(myAC, "T3");
	t1.start();
	t2.start();
	t3.start();
}
}
