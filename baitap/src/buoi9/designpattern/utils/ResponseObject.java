package buoi9.designpattern.utils;

public class ResponseObject {
	// ma tra ve
	private int resCode;
	// mo ta tra ve
	private String resDesc;
	public ResponseObject(int resCode, String resDesc) {
		super();
		this.resCode = resCode;
		this.resDesc = resDesc;
	}
	public ResponseObject() {
		super();
	}
	@Override
	public String toString() {
		return "ResponseObject [resCode=" + resCode + ", resDesc=" + resDesc + "]";
	}
	public int getResCode() {
		return resCode;
	}
	public void setResCode(int resCode) {
		this.resCode = resCode;
	}
	public String getResDesc() {
		return resDesc;
	}
	public void setResDesc(String resDesc) {
		this.resDesc = resDesc;
	}
	
}
