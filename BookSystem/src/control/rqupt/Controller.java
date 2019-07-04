package control.rqupt;

import model.cqupt.Book;
import model.cqupt.BookList;
/**
 * ҵ���߼�
 * @author Administrator
 *
 */
public class Controller {
	/**
	 * ���ͼ��
	 * 
	 * @param id
	 * @param name
	 * @param price
	 * @return
	 */
	public boolean addBook(String id, String name, String price) {
		BookList bookList = BookList.getBookList();
		int i = 0;
		for (; i < bookList.size(); ++i) {
			Book book2 = bookList.get(i);
			String bid = book2.getId();
			if (bid.equals(id)) {
				break;
			}
		}
		if (i == bookList.size()) {
			Book book = new Book(id, name, price);
			bookList.add(book);
			return true;
		}
		return false;

	}

	/**
	 * ����ͼ��
	 * 
	 * @return
	 */
	public BookList searchBook() {
		BookList bookList = BookList.getBookList();
		return bookList;
	}
	/**
	 * ɾ��ͼ��
	 * @param name
	 * @return
	 */
	public boolean deleteBook(String name) {
		BookList bookList = BookList.getBookList();
		for (int i = 0; i < bookList.size(); ++i) {
			Book book2 = bookList.get(i);

			if (book2.getName().equals(name)) {
				bookList.remove(i);
				return true;
			}
		}
		return false;

	}
	/**
	 * �޸�ͼ����Ϣ
	 * @param id
	 * @param name
	 * @param price
	 * @return
	 */
	public boolean setBook(String id,String name,String price){
		BookList bookList = BookList.getBookList();
		for (int i = 0; i < bookList.size(); ++i) {
			Book book2 = bookList.get(i);

			if (book2.getId().equals(id)) {
				Book book = new Book(id, name, price);
				bookList.set(i, book);
				return true;
			}
		}
		return false;
		
	}
}
