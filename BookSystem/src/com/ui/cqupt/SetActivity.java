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

public class SetActivity extends Activity {
	private EditText nameEditText;
	private EditText idEditText;
	private EditText priceEditText;
	private Button setButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_set);
		idEditText = (EditText) findViewById(R.id.edit3_1);
		nameEditText = (EditText) findViewById(R.id.edit3_2);
		priceEditText = (EditText) findViewById(R.id.edit3_3);
		setButton=(Button) findViewById(R.id.btn3_1);
		setButton.setOnClickListener(new ButtonListener());
	}
	//����һ���ڲ���ʵ�ֵ���¼��ӿ�Ϊ Ϊ�޸İ�ť����¼�
		class ButtonListener implements OnClickListener {

			public void onClick(View v) {
				String bookname = nameEditText.getText().toString();
				String bookid = idEditText.getText().toString();
				String bookprice = priceEditText.getText().toString();

				Controller control = new Controller();
				if (bookname.equals("") || bookid.equals("")
						|| bookprice.equals("")) {
					new Builder(SetActivity.this).setMessage("ͼ����Ϣ����Ϊ��").show();
				}
				else
				{
					if (control.setBook(bookid, bookname, bookprice)) {
						idEditText.setText("");
						nameEditText.setText("");
						priceEditText.setText("");
						buildDialog();
					}
					else {
						new Builder(SetActivity.this).setMessage("û�д˱�ŵ�ͼ�飬����������").show();
					}
				}
			}
			//����һ������ʹ��Dialog��ѯ���Ƿ�����޸�
			private void buildDialog() {
				Builder builder = new Builder(SetActivity.this);
				builder.setTitle("�޸ĳɹ�,�Ƿ�����޸�ͼ��");
				builder.setNegativeButton("������ҳ",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int whichButton) {
								finish();
							}

						});
				builder.setPositiveButton("�����޸�", null);
				builder.show();
			}

		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.set, menu);
		return true;
	}

}
