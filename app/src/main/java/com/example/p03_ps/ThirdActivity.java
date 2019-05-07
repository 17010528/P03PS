package com.example.p03_ps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btnSubmit = findViewById(R.id.buttonSubmit);
        final RadioGroup rg = findViewById(R.id.radioGroup1);
        final Intent i = new Intent();

        final int weekno = i.getIntExtra("weekno",0) + 1;
        TextView tvWeek = findViewById(R.id.textViewWeek);

        tvWeek.setText("week " + weekno);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                int selectedId = rg.getCheckedRadioButtonId();
                RadioButton radioAnswer = findViewById(selectedId);
                String grade = radioAnswer.getText().toString();

                i.putExtra("grade", grade);
                // Set result to RESULT_OK to indicate normal			// response and pass in the intent containing the 		// like
                setResult(RESULT_OK, i);
                finish();


            }
        });
    }
}
