//package buoi2;
//
//public class GrnericDemo {
//	public static void main(String[] args) {
//		Container c1= new Container(1);
//		Container c2= new Container("1");
//		Container c1= new Container(1);
//	}
//}
//class Container2 <T>{
//	public T obj;
//	public Container2(T o) {
//		this.obj=o;
//	}
//}
//class Container{
//	public Object obj;
//	public Container(Object obj) {
//		this.obj=obj;
//	}
//	@Override
//	public String toString() {
//		return super.toString();
//	}
//	@SuppressWarnings("removal")
//	@Override
//	public boolean equals(Object o) {
//			if(o==null) {
//				return false;
//			}
//			Integer res=0;
//			if(((Container)o).obj instanceof String) {
//				res=Integer.parseInt(o.toString());
//			}
//			if(this.obj instanceof Integer) {
//				if(res.compareTo(new Integer(this.obj.toString()))==0) {
//					return true;
//				}
//			}
//		
//		
//		return super.equals(o);
//	}
//	
//	
//}