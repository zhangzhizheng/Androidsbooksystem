package com.ui.cqupt;

import com.example.booksystem.R;

import control.rqupt.Controller;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * 删除图书
 * 
 * @author Administrator
 * 
 */
public class DeleteActivity extends Activity {
	private EditText nameEditText;
	private Button deleteButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_delete);
		// 获取控件
		nameEditText = (EditText) findViewById(R.id.edit2_1);
		deleteButton = (Button) findViewById(R.id.btn2_1);
		deleteButton.setOnClickListener(new ButtonListener());
	}

	// 定义一个内部类实现点击事件接口为为删除按钮添加事件
	class ButtonListener implements OnClickListener {

		public void onClick(View v) {
			String bookname = nameEditText.getText().toString();

			Controller control = new Controller();
			if (bookname.equals("")) {
				new Builder(DeleteActivity.this).setMessage("图书信息不能为空").show();
			} else {
				if (control.deleteBook(bookname)) {
					nameEditText.setText("");
					buildDialog();
				} else {
					new Builder(DeleteActivity.this).setMessage("没有此图书").show();
				}
			}
		}

		// 定义一个方法使用Dialog来询问是否继续删除
		private void buildDialog() {
			Builder builder = new Builder(DeleteActivity.this);
			builder.setTitle("删除成功,是否继续删除图书");
			builder.setNegativeButton("返回首页",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							finish();
						}

					});
			builder.setPositiveButton("继续删除", null);
			builder.show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.delete, menu);
		return true;
	}

}
