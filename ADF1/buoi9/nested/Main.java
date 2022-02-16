package buoi9.nested;

import buoi9.IWorker;
import buoi9.nested.People.Address;

public class Main {
	public static void main(String[] args) {
		IWorker cn2=new IWorker() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				System.out.println("cong nhan sua chua oto");
			}
		};
		cn2.doWork();
		IWorker cn3 =new IWorker() {
			
			@Override
			public void doWork() {
				// TODO Auto-generated method stub
				int ca1=100;
				int ca2=200;
				System.err.println(ca1+ca2);
			}
		};
		cn3.doWork();
//		IWorker cn1= new Congnhan();
//		cn1.doWork();
		
		
	}
	class Congnhan implements IWorker{
		
		@Override
		public void doWork() {
			// TODO Auto-generated method stub
			System.out.println("Cong nhan");
		}
		
	}
}
