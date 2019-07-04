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
 * ɾ��ͼ��
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
		// ��ȡ�ؼ�
		nameEditText = (EditText) findViewById(R.id.edit2_1);
		deleteButton = (Button) findViewById(R.id.btn2_1);
		deleteButton.setOnClickListener(new ButtonListener());
	}

	// ����һ���ڲ���ʵ�ֵ���¼��ӿ�ΪΪɾ����ť����¼�
	class ButtonListener implements OnClickListener {

		public void onClick(View v) {
			String bookname = nameEditText.getText().toString();

			Controller control = new Controller();
			if (bookname.equals("")) {
				new Builder(DeleteActivity.this).setMessage("ͼ����Ϣ����Ϊ��").show();
			} else {
				if (control.deleteBook(bookname)) {
					nameEditText.setText("");
					buildDialog();
				} else {
					new Builder(DeleteActivity.this).setMessage("û�д�ͼ��").show();
				}
			}
		}

		// ����һ������ʹ��Dialog��ѯ���Ƿ����ɾ��
		private void buildDialog() {
			Builder builder = new Builder(DeleteActivity.this);
			builder.setTitle("ɾ���ɹ�,�Ƿ����ɾ��ͼ��");
			builder.setNegativeButton("������ҳ",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							finish();
						}

					});
			builder.setPositiveButton("����ɾ��", null);
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
