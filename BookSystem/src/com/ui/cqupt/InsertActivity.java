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
 * ͼ�����
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

	// ����һ���ڲ���ʵ�ֵ���¼��ӿ�Ϊ���밴ť����¼�
	class ButtonListener implements OnClickListener {

		public void onClick(View v) {
			String bookid = idEditText.getText().toString();
			String bookname = nameEditText.getText().toString();
			String bookprice = priceEditText.getText().toString();
			Controller control = new Controller();
			if (bookname.equals("") || bookid.equals("")
					|| bookprice.equals("")) {
				new Builder(InsertActivity.this).setMessage("ͼ����Ϣ����Ϊ��").show();
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
					new Builder(InsertActivity.this).setMessage("���д�ͼ��").show();
				}
			}
		}
		//����һ������ʹ��Dialog��ѯ���Ƿ��������
		private void buildDialog() {
			Builder builder = new Builder(InsertActivity.this);
			builder.setTitle("����ɹ�,�Ƿ��������ͼ��");
			builder.setNegativeButton("������ҳ",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							finish();
						}

					});
			builder.setPositiveButton("��������", null);
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
