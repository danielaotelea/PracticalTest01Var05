package ro.pub.cs.systems.pdsd.practicalTest01Var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var05SecondaryActivity extends Activity {
	
	final private int[] ButtonIds = {
			R.id.aux1, R.id.aux2
	};
	private ButtonClickListener2 buttonClickListener = new ButtonClickListener2();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_secondary);
		for(int i = 0; i < ButtonIds.length; i++)
		{
			Button b = (Button)findViewById(ButtonIds[i]);
			b.setOnClickListener(buttonClickListener);
		}
		
		Intent intent = getIntent();
		EditText ed = (EditText)findViewById(R.id.edit1);
		EditText ed2 = (EditText)findViewById(R.id.edit2);
		
		
	    if (intent != null) {
	    	 String secventa1 = intent.getStringExtra("contor");
		      if (secventa1 != null) {
		        ed.setText(secventa1);
		      }

	      String secventa2 = intent.getStringExtra("secventa");
	      if (secventa2 != null) {
	        ed2.setText(secventa2);
	      }
	      
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.practical_test01_var05_secondary, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private class ButtonClickListener2 implements View.OnClickListener{
		
		
		@Override
		public void onClick(View v) {
			if(v instanceof Button)
			{
				if (v.getId() == R.id.aux1){
					setResult(RESULT_OK, new Intent());
					finish();
				} else if(v.getId() == R.id.aux2)
				{
					setResult(RESULT_CANCELED, new Intent());
					finish();
				}
			}
		}
	}
}
