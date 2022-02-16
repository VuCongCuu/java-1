package buoi11.lambda;

public class LambdaDemo {
	public static void main(String[] args) {
		Button btnRun= new ButtonRun();
		btnRun.click();
		Button btnNew= new Button() {

			@Override
			public void click() {
				// TODO Auto-generated method stub
				System.out.println("create new project");
			}
			
		};
		btnNew.click();
		Button btnSave=()->System.out.println("Save source");
		btnSave.click();
	}
}
interface IWork{
	void doWork();
	void show();
}
interface Button{
	void click();
	static String name="BTN";
	static String getName() {
		return name;
	}
	default void test() {
		System.out.println("test button");
	}
}
class ButtonRun implements Button  {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("Run main");
	}
	
}