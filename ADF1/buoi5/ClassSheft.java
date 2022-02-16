package buoi5;

public class ClassSheft {
	private QLClass[] dsLopHoc;
	private int index=0;

	public ClassSheft() {
		super();
	}
	public void showDsLop(){
		for(QLClass a : this.dsLopHoc) {
			if(a != null) {
				System.out.println(a.toString());
			}
		}
				
	}
//	public boolean addClasstoClassShelf(QLClass lop) {
//		if(lop==null) {
//			return false;
//		}
//		
//		
//	}
//	public QLClass findClassByCode (String code) {
//		if(code==null || code.length() ==0) {
//			return null;
//		}
//		
//	}
}
//public boolean addBookToShelf(Book book) {
//	if (book == null) {
//		return false;
//	}
//	if (this.index == this.dsBook.length) {
//		return false;
//	}
//	this.dsBook[this.index] = book;
//	this.index++;
//	return true;
//}
//timlophoctheo ma
//public Book findBookByCode(String maSach) {
//	if(maSach==null || maSach.length()==0) {
//		return null;
//	}
//	for(int i=0;i<this.index;i++) {
//		if(maSach.equalsIgnoreCase(this.dsBook[i].getCode())) {
//			return this.dsBook[i];
//		}
//	}
//	return null;
//}
//public int addListBookToShelf(Book[] listBook) {
//	if (listBook == null)
//		return -1;
//	if (this.index == this.dsBook.length) {
//		return 0;
//	}
//	int i = 0;
//	for (Book book : listBook) {
//		if (this.index < this.dsBook.length) {
//			this.dsBook[this.index++] = book;
//			i++;
//		}
//	}
//
//	return i;
//}