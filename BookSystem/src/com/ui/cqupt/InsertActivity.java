package com.ui.cqupt;

import com.example.booksystem.R;

import control.rqupt.Controller;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;

/**
 * 图书插入
 * 
 * @author Administrator
 * 
 */
public class InsertActivity extends Activity {
	private EditText nameEditText;
	private EditText idEditText;
	private EditText priceEditText;
	private Button addButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_insert);
		idEditText = (EditText) findViewById(R.id.edit1_1);
		nameEditText = (EditText) findViewById(R.id.edit1_2);
		priceEditText = (EditText) findViewById(R.id.edit1_3);
		addButton = (Button) findViewById(R.id.btn1_1);
		addButton.setOnClickListener(new ButtonListener());

	}

	// 定义一个内部类实现点击事件接口为插入按钮添加事件
	class ButtonListener implements OnClickListener {

		public void onClick(View v) {
			String bookid = idEditText.getText().toString();
			String bookname = nameEditText.getText().toString();
			String bookprice = priceEditText.getText().toString();
			Controller control = new Controller();
			if (bookname.equals("") || bookid.equals("")
					|| bookprice.equals("")) {
				new Builder(InsertActivity.this).setMessage("图书信息不能为空").show();
			}
			else
			{
				if (control.addBook(bookid, bookname, bookprice)) {
					idEditText.setText("");
					nameEditText.setText("");
					priceEditText.setText("");
					buildDialog();
				}
				else {
					new Builder(InsertActivity.this).setMessage("已有此图书").show();
				}
			}
		}
		//定义一个方法使用Dialog来询问是否继续插入
		private void buildDialog() {
			Builder builder = new Builder(InsertActivity.this);
			builder.setTitle("插入成功,是否继续插入图书");
			builder.setNegativeButton("返回首页",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							finish();
						}

					});
			builder.setPositiveButton("继续插入", null);
			builder.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert, menu);
		return true;
	}

}
