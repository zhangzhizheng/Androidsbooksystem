package com.ui.cqupt;

import com.example.booksystem.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
/**
 * Ö÷½çÃæ
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button insert = (Button) findViewById( R.id.addbtn);
		Button delete = (Button) findViewById( R.id.deletebtn);
		Button set = (Button) findViewById(R.id.updatebtn);
		Button select = (Button) findViewById( R.id.selectbtn);
		ButtonListener buttonListener = new ButtonListener();
		insert.setOnClickListener(buttonListener);
		delete.setOnClickListener(buttonListener);
		set.setOnClickListener(buttonListener);
		select.setOnClickListener(buttonListener);
    }
    class ButtonListener implements OnClickListener {

		public void onClick(View v) {
			int id = v.getId();
			Intent intent = new Intent();
			switch (id) {
			case R.id.addbtn:
				intent.setClass(MainActivity.this,InsertActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.deletebtn:
				intent.setClass(MainActivity.this, DeleteActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.updatebtn:
				intent.setClass(MainActivity.this, SetActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			case R.id.selectbtn:
				intent.setClass(MainActivity.this, SelectActivity.class);
				MainActivity.this.startActivity(intent);
				break;
			}
		}


	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
