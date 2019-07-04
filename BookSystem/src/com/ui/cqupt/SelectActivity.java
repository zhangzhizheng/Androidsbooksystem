package com.ui.cqupt;

import model.cqupt.Book;
import model.cqupt.BookList;

import com.example.booksystem.R;

import control.rqupt.Controller;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
/**
 * 查询图书
 * @author Administrator
 *
 */
public class SelectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
		Controller controller=new Controller();
		BookList bookList=controller.searchBook();
		createTable(bookList);
	}
	/**
	 * 创建表格的方法
	 * @param bookList
	 */
	private void createTable(BookList bookList){
		TableLayout tableLayout=(TableLayout) findViewById(R.id.SELECT_TableLayout);
		for(int i=0;i<bookList.size();++i){
			//获取书的信息
			Book book=bookList.get(i);
			String bookid=book.getId();
			String bookname=book.getName();
			String bookprice=book.getPrice();
			//把数的信息展示到控件上
			TableRow tableRow=new TableRow(this);
			TextView tvid=new TextView(this);
			TextView tvname=new TextView(this);
			TextView tvprice=new TextView(this);
			tvid.setText(bookid);
			tvname.setText(bookname);
			tvprice.setText(bookprice);
			//先把数据绑在一行再绑在表格上
			tableRow.addView(tvid);
			tableRow.addView(tvname);
			tableRow.addView(tvprice);
			tableLayout.addView(tableRow);
			
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}

}
