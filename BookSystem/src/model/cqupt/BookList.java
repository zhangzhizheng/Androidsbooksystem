package model.cqupt;

import java.util.ArrayList;
import java.util.Collection;
/**
 * ģ�����ݴ洢
 * @author Administrator
 *
 */
public class BookList extends ArrayList<Book>{
	private static BookList bookList=null;

	public BookList() {
		Book b1=new Book("001","c++","28");
		Book b2=new Book("002","��","28.9");
		Book b3=new Book("003","ƽ��������","38");
		add(b1);
		add(b2);
		add(b3);	
	}
	public static BookList getBookList(){
		if (bookList==null) {
			bookList=new BookList();
		}
		return bookList;
	}

	

}
