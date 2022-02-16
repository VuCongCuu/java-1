package buoi3;
import java.io.File;
public class FileDescription {
	public static void main(String[] args) {
	String rootPath="D:\\video bài giảng AI";
	String path2="baitappjava	";
	String projectPath= System.getProperty("user.dir");
	System.out.println(projectPath);
	File projectFile= new File(projectPath);
	System.out.println("thu muc ton tai hay khong : "+ (projectFile.exists()==true?"Ton tai":"khong ton tai"));
	File pathFile= new File(path2);
	System.out.println("thu muc ton tai hay khong : "+ (pathFile.exists()==true?"Ton tai":"khong ton tai"));
	// kiem tra file la thu muc hay tep
	System.out.println(projectFile.isDirectory()+" hay file "+ projectFile.isFile());
	System.out.println(projectFile.getName());
	System.out.println(projectFile.delete());
	System.out.println(projectFile.getParent());
	System.out.println(projectFile.getTotalSpace()*(1e-6));
	System.out.println(projectFile.getFreeSpace());
	System.out.println(projectFile.getTotalSpace());
	System.out.println(projectFile.getUsableSpace());
	System.out.println(projectFile.getAbsolutePath());
	//lay cac thu muc con cap 1
	File[] listFile= projectFile.listFiles();
	for(File b :listFile) {
		System.out.println((b.isDirectory()==true?"+":"-")+ b.getName());
	}
	
	}
}
