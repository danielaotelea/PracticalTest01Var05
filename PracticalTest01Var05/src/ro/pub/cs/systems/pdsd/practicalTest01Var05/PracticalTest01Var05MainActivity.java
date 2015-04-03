package ro.pub.cs.systems.pdsd.practicalTest01Var05;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var05MainActivity extends Activity {

private ButtonClickListener buttonClickListener = new ButtonClickListener();
	
	static int contor = 0;
	final private int[] ButtonIds = {
			R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.go2sec
	};
	final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_var05_main);
		
		for(int i = 0; i < ButtonIds.length; i++)
		{
			Button b = (Button)findViewById(ButtonIds[i]);
			b.setOnClickListener(buttonClickListener);
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_var05_main, menu);
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
	
	@Override
	protected void onSaveInstanceState(Bundle savedInstanceState)
	{
		super.onSaveInstanceState(savedInstanceState);
		savedInstanceState.putString("go_2_sec",Integer.toString(contor));
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		if(savedInstanceState != null)
		{
			if(savedInstanceState.getString("go_2_sec") != null)
			{
				Toast.makeText(this, "S-a salvat " +savedInstanceState.getString("go_2_sec"), Toast.LENGTH_LONG).show();
			} 
		} else
		{
			Toast.makeText(this, "NU s-a salvat", Toast.LENGTH_LONG).show();
		}
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    contor++;
	    EditText ed = (EditText)findViewById(R.id.editText1);
	    ed.setText(null);
	  }
	
	private class ButtonClickListener implements View.OnClickListener{
		
		
		@Override
		public void onClick(View v) {
			EditText ed = (EditText)findViewById(R.id.editText1);
			
			if(v instanceof Button)
			{
				if( (ed.getText().toString().length() > 0) && (((Button)v).getId() != R.id.go2sec))
				{
					ed.setText(ed.getText() + ", ");
				}
				
				if(((Button)v).getId() == R.id.button1)
				{
					ed.setText(ed.getText() + "North");
				}
				if(((Button)v).getId() == R.id.button2)
				{
					ed.setText(ed.getText() + "West");
				}
				
				if(((Button)v).getId() == R.id.button3)
				{
					ed.setText(ed.getText() + "East");
				}
				if(((Button)v).getId() == R.id.button4)
				{
					ed.setText(ed.getText() + "South");
				}
				
				
				if(((Button)v).getId() == R.id.go2sec)
				{
					Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
					intent.putExtra("secventa",ed.getText().toString());
					intent.putExtra("contor",Integer.toString(contor));
					startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
				}
			}
		}
	}
}
