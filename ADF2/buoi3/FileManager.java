package buoi3;

import java.io.File;

public class FileManager {
	public static void main(String[] args) {
		String rootPath= System.getProperty("user.dir");
		File dir= new File(rootPath);
		deQuy(dir,1);
		
	}
	public static void deQuy(File file,int lever ) {
		if(file==null||file.exists()==false) return;
		//xax dinh khoang trang
		StringBuilder space=new StringBuilder("");
		for(int i=0;i<lever;i++) {
			space.append("   ");
		}
		if(file.isDirectory()==true) {
			File[] listFile= file.listFiles();
			System.out.println(space.toString()+"+"+file.getName());
			lever++;
			for(File li :listFile) {
				deQuy(li,lever);
			}
		} else {
			//ket thuc de quy
			System.out.println(space.toString()+"-"+file.getName());	
		}
	}
}
//	public static void main(String[] args){
//
//        String rootpath = System.getProperty("user.dir");
//        File dir = new File(rootpath);
//        traveldir(dir,0);
//
//    }
//    // hàm đệ quy là hàm gọi tới chinh nó để thực hiện lại cùng hành vi nhiều lần
//    // tránh đệ quy vô hạn: luôn phải có lệnh kết thúc/điểm dừng của hàm
//    public static void traveldir(File file,int level){
//        if(file == null || file.exists() == false || level <0){
//            return;
//        }
//        StringBuilder space =new StringBuilder("");
//        for (int i =0;i<level;i++){
//            space.append("  ");
//        }
//        //xac dinh khoang trang
//
//        if (file.isDirectory()) {
//            System.out.println(space+"+" +file.getName());
//            File[] listfile = file.listFiles();
//            for (File li: listfile
//            ) {
//
//                traveldir(li,level+1);
//            }
//        }else {
//            System.out.println(space.toString()+"-" +file.getName());
//        }
//    }

