package com.jakev.debugnative;

import android.app.Activity;
import com.jakev.debugnative.R;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	EditText answerText;
	Button submitButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.main);
        
        System.loadLibrary("native");
        
        answerText = (EditText) findViewById(R.id.answerText);
        submitButton = (Button) findViewById(R.id.submitButton);
        
        submitButton.setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		String answerString;
		int checked;
		
		answerString = answerText.getText().toString();
		checked = check(answerString);
		
		if (checked == 0) {
				Toast answerToast = Toast.makeText(this, (CharSequence) "Wrong", Toast.LENGTH_LONG);
				answerToast.show();
		}
		else{
				Toast answerToast = Toast.makeText(this, (CharSequence) "Right", Toast.LENGTH_LONG);
				answerToast.show();			
		}
			
	}
	public native int check(String inputString );
}