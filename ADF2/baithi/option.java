package baithi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class option {
	public static  List<Book> booklist = new ArrayList<>();
	public static boolean addBook(Book book) {
		boolean res = false;
		if(book!=null) {
			booklist.add(book);
			res=true;
		}
		return res;
	}
	static void readFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try
        {
            fis = new FileInputStream("book.dat");

            ois = new ObjectInputStream(fis);

            Object obj = null;
            while ((obj = ois.readObject()) != null) {
                Book std = (Book) obj;
                System.out.println(std);

            }
        }catch(
                FileNotFoundException a)
        {        
            a.printStackTrace();
        }catch(
                IOException b)
        {
            b.printStackTrace();
        }catch(
                ClassNotFoundException e)
        {      
            e.printStackTrace();
        }finally
        {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }


    static void saveFile(List<Book> booklis) {
       

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try
        {
            fos = new FileOutputStream("book.dat");
            oos = new ObjectOutputStream(fos);

            for (Book book : booklist) {
                oos.writeObject(book);
            }
        }catch(
                FileNotFoundException a)
        {
            // TODO Auto-generated catch block
            a.printStackTrace();
        }catch(
                IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally
        {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
