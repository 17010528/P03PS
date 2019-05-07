package com.example.p03_ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Module> module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("P03-ClassJournal");

        lv = this.findViewById(R.id.lvModule);

        module = new ArrayList<Module>();
        module.add(new Module("C347"));

        aa = new ModuleAdapter(this, R.layout.row1 , module);
        lv.setAdapter(aa);

//        lv.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View arg0) {
//                // Create Hero object of strength 100 & technical 60

//
//            }});
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(MainActivity.this,
                        ModuleInfoView.class);
                // Put hero object in intent
//                i.putExtra("module", module);
                // Start activity with requestCodeForSupermanStats to
                // identify it was started by clicking on Superman
                startActivity(i);


            }
        });
    }

}
