package com.example.p03_ps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ModuleInfoView extends AppCompatActivity {
    ListView lv1;
    ArrayAdapter aa1;
    ArrayList<ModuleInfo> moduleinfo;
    Button btnInfo, btnAdd, btnEmail;
    private final static int REQUEST_CODE_1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_info_view);

        Intent i = getIntent();
        Module module = (Module) i.getSerializableExtra("module");

        lv1 = this.findViewById(R.id.lvModuleInfo);
        moduleinfo = new ArrayList<ModuleInfo>();
        moduleinfo.add(new ModuleInfo(1, "B", "C347"));
        moduleinfo.add(new ModuleInfo(2, "C" , "C347"));
        moduleinfo.add(new ModuleInfo(3, "A", "C347"));
        aa1 = new ModuleInfoAdapter(this, R.layout.rowinfo, moduleinfo);
        lv1.setAdapter(aa1);
        String sentence = "";
        for(int c=0; c < moduleinfo.size(); c++){
            sentence += "Week "+ moduleinfo.get(c).getWeek() + ": DG:" + moduleinfo.get(c).getGrade() +"\n";
        }

        btnInfo = findViewById(R.id.buttonInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/r47"));
                startActivity(rpIntent);
            }
        });

        btnEmail = findViewById(R.id.buttonEmail);
        final String finalSentence = sentence;
        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_TEXT,
                        finalSentence);
                // This MIME type indicates email
                email.setType("message/rfc822");
                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));

            }
        });

        btnAdd = findViewById(R.id.buttonAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent i = new Intent(ModuleInfoView.this, ThirdActivity.class);
                int weekno = moduleinfo.get(moduleinfo.size() - 1).getWeek();
                i.putExtra("weekno", weekno);
                startActivityForResult(i, REQUEST_CODE_1);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        switch (requestCode) {
            case REQUEST_CODE_1:

                if (resultCode == RESULT_OK) {

                    // Get data passed back from 2nd activity
//                    int week = 4;
//                    String weekString = "Week " + week;
                    String result = data.getStringExtra("result");
                    moduleinfo.add(new ModuleInfo(moduleinfo.get(moduleinfo.size()-1).getWeek()+1 , result , "C347"));

                }
        }
    }
}
