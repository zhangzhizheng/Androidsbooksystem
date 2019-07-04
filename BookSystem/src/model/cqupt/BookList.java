package model.cqupt;

import java.util.ArrayList;
import java.util.Collection;
/**
 * 模拟数据存储
 * @author Administrator
 *
 */
public class BookList extends ArrayList<Book>{
	private static BookList bookList=null;

	public BookList() {
		Book b1=new Book("001","c++","28");
		Book b2=new Book("002","蛙","28.9");
		Book b3=new Book("003","平凡的世界","38");
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
