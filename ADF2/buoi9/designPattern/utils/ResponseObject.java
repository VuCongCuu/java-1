package buoi9.designPattern.utils;

public class ResponseObject {
 private int resCode;
 private String resDesc;
public ResponseObject() {
	super();
}
public ResponseObject(int resCode, String resDesc) {
	super();
	this.resCode = resCode;
	this.resDesc = resDesc;
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
